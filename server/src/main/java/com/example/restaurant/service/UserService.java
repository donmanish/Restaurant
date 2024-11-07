package com.example.restaurant.service;

import com.example.restaurant.model.User;

import java.util.List;

public interface UserService {
   User createUser(User user);
   User getUserById(int id);
   User updateUser(User user);
   void deleteUser(int id);
   List<User> getAllUsers();
}
