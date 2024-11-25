package com.unsij.backend.usersapp.backend_userapp.services;

import java.util.List;
import java.util.Optional;

import com.unsij.backend.usersapp.backend_userapp.models.entities.User;

public interface UserService {
    List<User> findAll();
    Optional<User> findById();
    User save (User user);
    void remove (Long id);
    void delete (User user);
}
