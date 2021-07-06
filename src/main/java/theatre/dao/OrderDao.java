package theatre.dao;

import java.util.List;
import theatre.model.Order;
import theatre.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
