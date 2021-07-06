package theatre.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import theatre.dao.AbstractDao;
import theatre.dao.RoleDao;
import theatre.exception.DataProcessingException;
import theatre.model.Role;
import theatre.model.RoleName;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> findByNameQuery = session.createQuery(
                    "FROM Role WHERE name = :name", Role.class);
            findByNameQuery.setParameter("name", RoleName.valueOf(roleName));
            return findByNameQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role " + roleName + " not found", e);
        }
    }
}
