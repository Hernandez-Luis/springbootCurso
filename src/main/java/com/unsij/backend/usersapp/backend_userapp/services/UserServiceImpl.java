package com.unsij.backend.usersapp.backend_userapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unsij.backend.usersapp.backend_userapp.models.entities.User;
import com.unsij.backend.usersapp.backend_userapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional (readOnly = true)
    public List<User> findAll() {
        return (List <User>) userRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> update(User user, Long id) {
        Optional<User> userOptional = this.findById(id);
        User userResult = null;
        if(userOptional.isPresent()){
            User userBD = userOptional.orElseThrow();
            userBD.setEmail(user.getEmail());
            userBD.setUsername(user.getUsername());
            userResult= this.save(userBD);
        }
        return Optional.ofNullable(userResult);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
