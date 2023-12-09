package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.User;
import com.telecom.telecomplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/getUserById/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/user/updateUser/{id}")
    public User updateUser(@RequestBody User updatedUser, @PathVariable  Long id){
        return userService.updateUser(id, updatedUser);
    }

    @PostMapping("/user/createUser")
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @DeleteMapping("/user/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUserById(id);
    }
}
