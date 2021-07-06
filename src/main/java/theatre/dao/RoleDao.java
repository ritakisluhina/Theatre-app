package theatre.dao;

import java.util.Optional;
import theatre.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
