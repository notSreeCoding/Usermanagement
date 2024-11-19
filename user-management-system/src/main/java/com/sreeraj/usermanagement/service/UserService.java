package com.sreeraj.usermanagement.service;

import com.sreeraj.usermanagement.model.User;
import com.sreeraj.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Create or update a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
