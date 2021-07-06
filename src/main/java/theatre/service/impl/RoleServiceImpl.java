package theatre.service.impl;

import org.springframework.stereotype.Service;
import theatre.dao.RoleDao;
import theatre.exception.DataProcessingException;
import theatre.model.Role;
import theatre.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName)
                .orElseThrow(() -> new DataProcessingException("Can't get role by name: "
                        + roleName));
    }
}
