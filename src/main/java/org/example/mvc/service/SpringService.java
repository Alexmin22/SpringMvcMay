package org.example.mvc.service;

import org.example.mvc.dao.UserDao;
import org.example.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SpringService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public void createUser(User user) {
        userDao.saveUser(user);
    }
    public Optional<User> getUser(int id) {
        return userDao.getUser(id);
    }

    public void deleteUser(int id) {
        userDao.deleteUserById(id);
    }

}
