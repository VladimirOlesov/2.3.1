package web.service;

import java.util.List;

import web.model.User;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);

    User getUser(Long id);
}
