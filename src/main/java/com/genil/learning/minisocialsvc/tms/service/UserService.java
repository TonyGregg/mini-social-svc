package com.genil.learning.minisocialsvc.tms.service;

import com.genil.learning.minisocialsvc.tms.model.User;

import java.util.List;

/**
 * Created by Antony Genil Gregory on 1/7/2020 3:46 PM
 * For project : mini-social-svc
 **/
public interface UserService {
    List<User> getAllUsers();
    User getUser(Integer userId);
    User addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
