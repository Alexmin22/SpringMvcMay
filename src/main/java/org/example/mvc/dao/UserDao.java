package org.example.mvc.dao;


import org.example.mvc.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();
    void saveUser(User user);
    Optional<User> getUser(int id);
    void deleteUserById(int id);

}
