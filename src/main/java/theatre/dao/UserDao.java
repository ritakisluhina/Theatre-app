package theatre.dao;

import java.util.Optional;
import theatre.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
