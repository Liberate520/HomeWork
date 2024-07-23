package service;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUserService {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User authenticateUser(String login, String passwordHash) {
        return users.values().stream()
                .filter(user -> user.getLogin().equals(login) && user.getPasswordHash().equals(passwordHash))
                .findFirst().orElse(null);
    }

    @Override
    public User getUserById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
