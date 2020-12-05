package com.booksmart.service;

import com.booksmart.entity.User;

public interface UserService {
    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user);

    User findById(Long id);

    User save(User user);
}