package com.list.service;

import com.list.domain.User;
import com.list.repository.UserRepository;

import java.util.Optional;
import java.util.List;

public class UserService implements UserServiceInt {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE

    // READ
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found with email: " + email));
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
