package com.list.service;

import com.list.domain.User;
import com.list.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

public class UserService implements UserServiceInt {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public User createUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("E-mail já cadastrado");
        }
        return userRepository.save(user);
    }

    // READ
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // UPDATE

    // DELETE
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
