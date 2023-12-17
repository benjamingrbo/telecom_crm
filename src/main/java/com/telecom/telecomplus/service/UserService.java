package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.User;
import com.telecom.telecomplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId)
                .map(user -> {

                    if (updatedUser.getUsername() != null) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if(updatedUser.getPassword() != null){
                        user.setPassword(updatedUser.getPassword());
                    }
                    if(updatedUser.getEmail() != null){
                        user.setEmail(updatedUser.getEmail());
                    }
                    if(updatedUser.getRole() != null){
                        user.setRole(updatedUser.getRole());
                    }
                    if(updatedUser.getCustomer() != null){
                        user.setCustomer(updatedUser.getCustomer());
                    }

                    return userRepository.save(user);
                })
                .orElse(null);
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }


    public String deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return "User with id: " + userId + " has been deleted.";
    }
}
