package theatre.util;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import theatre.model.Role;
import theatre.model.RoleName;
import theatre.model.User;
import theatre.service.RoleService;
import theatre.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setName(RoleName.ROLE_ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(RoleName.ROLE_USER);
        roleService.add(userRole);
        User ben = new User();
        ben.setEmail("james@gmail.com");
        ben.setPassword("1234");
        ben.setRoles(Set.of(adminRole));
        userService.add(ben);
        User alex = new User();
        alex.setEmail("alex@gmail.com");
        alex.setPassword("1234");
        alex.setRoles(Set.of(userRole));
        userService.add(alex);
    }
}
