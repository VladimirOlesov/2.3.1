package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDaoImp;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDaoImp.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDaoImp.deleteUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoImp.updateUser(user);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDaoImp.getUser(id);
    }
}
