package com.example.restaurant.service;

import com.example.restaurant.model.User;
import com.example.restaurant.repositry.UserRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DbStoreUserService")
public class DbStoreUserService implements UserService{

    private UserRepositry userRepositry;
    public DbStoreUserService(UserRepositry userRepositry) {
        this.userRepositry = userRepositry;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
