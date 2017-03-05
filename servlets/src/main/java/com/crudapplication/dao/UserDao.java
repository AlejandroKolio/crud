package com.crudapplication.dao;

import com.crudapplication.model.User;

import java.util.List;

/**
 * Created by Aleksandr_Shakhov on 05.03.17 18:11.
 */


public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
}
