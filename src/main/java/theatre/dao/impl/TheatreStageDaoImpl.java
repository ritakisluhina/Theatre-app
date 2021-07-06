package theatre.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.dao.AbstractDao;
import theatre.dao.TheatreStageDao;
import theatre.model.TheatreStage;

@Repository
public class TheatreStageDaoImpl extends AbstractDao<TheatreStage> implements TheatreStageDao {
    public TheatreStageDaoImpl(SessionFactory factory) {
        super(factory, TheatreStage.class);
    }
}
