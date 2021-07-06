package theatre.service.impl;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import theatre.exception.DataProcessingException;
import theatre.model.User;
import theatre.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;
    
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.findByEmail(email);
        } catch (DataProcessingException e) {
            throw new UsernameNotFoundException("Can't get user by email: " + email, e);
        }
        UserBuilder userBuilder =
                org.springframework.security.core.userdetails.User.withUsername(email);
        userBuilder.password(user.getPassword());
        userBuilder.authorities(user.getRoles().stream()
                .map(r -> r.getName().name())
                .toArray(String[]::new));
        return userBuilder.build();
    }
}
