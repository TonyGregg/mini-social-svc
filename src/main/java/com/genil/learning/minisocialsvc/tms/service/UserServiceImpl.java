package com.genil.learning.minisocialsvc.tms.service;

import com.genil.learning.minisocialsvc.tms.exception.UserNotFoundException;
import com.genil.learning.minisocialsvc.tms.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public void updateUser(User user) {
    getAllUsers()
            .stream()
            .filter(user1-> user.getUserId() == user1.getUserId())
            .findAny()
            .orElseThrow(()->new UserNotFoundException("User not found with id "+user.getUserId()))
            .setUserName(user.getUserName());
  }

  @Override
  public void deleteUser(User user) {
    getAllUsers().removeIf(user1 -> user1.getUserId() == user.getUserId());
  }

  @Override
  public User addUser(User user) {
     getAllUsers().add(user);
     return user;
  }

  @Override
  public List<User> getAllUsers() {
    return this.users;
  }

  @Override
  public User getUser(Integer userId) {
    return getAllUsers()
            .stream()
            .filter(user -> user.getUserId() == userId)
            .findAny()
            .orElse(new User(0, "Not available"));
  }

  // Dummy users
  public static List<User> users;
  public UserServiceImpl() {
    users = new LinkedList<>();
    users.add(new User(100, "David"));
    users.add(new User(101, "Peter"));
    users.add(new User(102, "John"));
  }
}