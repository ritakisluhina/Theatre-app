package theatre.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import theatre.dao.UserDao;
import theatre.exception.DataProcessingException;
import theatre.model.User;
import theatre.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserDao userDao;

    public UserServiceImpl(PasswordEncoder encoder, UserDao userDao) {
        this.encoder = encoder;
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(
                () -> new DataProcessingException("User with id " + id + " not found"));
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(
                () -> new DataProcessingException("User with email " + email + " not found"));
    }
}
