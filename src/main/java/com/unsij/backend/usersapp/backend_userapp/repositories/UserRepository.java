package com.unsij.backend.usersapp.backend_userapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.unsij.backend.usersapp.backend_userapp.models.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
