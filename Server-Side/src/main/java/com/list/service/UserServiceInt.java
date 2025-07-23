package com.list.service;

import com.list.domain.User;

import java.util.Optional;
import java.util.List;

public interface UserServiceInt {
    User createUser(User user);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
}
