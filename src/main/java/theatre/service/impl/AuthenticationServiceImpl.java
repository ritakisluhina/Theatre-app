package theatre.service.impl;

import java.util.Set;
import org.springframework.stereotype.Service;
import theatre.model.RoleName;
import theatre.model.User;
import theatre.service.AuthenticationService;
import theatre.service.RoleService;
import theatre.service.ShoppingCartService;
import theatre.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;
    
    public AuthenticationServiceImpl(UserService userService,
            ShoppingCartService shoppingCartService, RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getRoleByName(RoleName.ROLE_USER.name())));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
