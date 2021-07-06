package theatre.service;

import theatre.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
