package theatre.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.dao.AbstractDao;
import theatre.dao.TicketDao;
import theatre.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
