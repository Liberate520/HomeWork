package service;

import model.User;

import java.util.List;

public interface IUserService {
    void registerUser(User user);
    User authenticateUser(String login, String passwordHash);
    User getUserById(String id);
    List<User> getAllUsers();
}
