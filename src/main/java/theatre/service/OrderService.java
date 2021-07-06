package theatre.service;

import java.util.List;
import theatre.model.Order;
import theatre.model.ShoppingCart;
import theatre.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
