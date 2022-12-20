package com.brian.twitterlite.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brian.twitterlite.models.User;
import com.brian.twitterlite.models.UserLogin;
import com.brian.twitterlite.repositories.PostRepository;
import com.brian.twitterlite.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        user.setAdmin(false);
        return userRepository.save(user);
    }

    public User login(UserLogin userLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        User existingUser = getUser(userLogin.getEmail());
		if(existingUser == null) {
			result.rejectValue("email", "Unique" ,"unknown Email");
			return null;
		}
		if(!BCrypt.checkpw(userLogin.getPassword(), existingUser.getPassword())) {
			result.rejectValue("password", "Matches", "Incorrect Password");
			return null;
		}
		return existingUser;
    }


    //get user by email, if not found return null
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUsername(String username) {
        if (userRepository.findByUsername(username) == null) {
            return null;
        }
        return userRepository.findByUsername(username);
    }


    //create user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //find user by id
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //find all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //update user
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
