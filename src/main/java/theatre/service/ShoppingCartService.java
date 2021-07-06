package theatre.service;

import theatre.model.PerformanceSession;
import theatre.model.ShoppingCart;
import theatre.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
