package theatre.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.dao.AbstractDao;
import theatre.dao.PerformanceDao;
import theatre.model.Performance;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
