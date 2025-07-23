package com.list.service;

import com.list.domain.User;

import java.util.Optional;

public interface UserServiceInt {
    Optional<User> getUserByEmail(String email);

}
