package theatre.service;

import theatre.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
