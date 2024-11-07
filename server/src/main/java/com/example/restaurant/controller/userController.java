package com.example.restaurant.controller;

import com.example.restaurant.model.User;
import com.example.restaurant.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    private UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    //create the users
    @PostMapping("/user")
    public User createUser(@RequestBody User  users) {
        return null;
    }

    //read one user
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int userid) {
        return null;
    }
    //read All users
    @GetMapping("/user")
    public List<User> getAllUser()
    {
        return null;
    }
    //update by id user
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int userid,  @RequestBody User updateuser) {
        return null;
    }

    //delete bt id users
    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable("id") int userid) {
        return null;
    }
}
