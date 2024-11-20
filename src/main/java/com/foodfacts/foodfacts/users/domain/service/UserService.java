package com.foodfacts.foodfacts.users.domain.service;

import com.foodfacts.foodfacts.users.domain.model.User;
import com.foodfacts.foodfacts.users.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a new user (POST)
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Method to get a user by ID (GET)
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to get all users (GET)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}