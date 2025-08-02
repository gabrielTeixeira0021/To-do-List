package com.list.service;

import com.list.domain.User;

import java.util.Optional;

public interface UserServiceInt {
    User createUser(User user);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
}