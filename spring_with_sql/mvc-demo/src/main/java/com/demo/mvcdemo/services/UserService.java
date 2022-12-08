package com.demo.mvcdemo.services;

import org.springframework.stereotype.Service;

import com.demo.mvcdemo.models.User;
import com.demo.mvcdemo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create a user
    public User create(User user) {
        return userRepository.save(user);
    }

    //get all users
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    //get one user
    public User findOneUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //get one user by email
    public User findOneUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    
}
