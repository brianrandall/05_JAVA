package com.assignments.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.assignments.projectmanager.models.User;
import com.assignments.projectmanager.models.UserLogin;
import com.assignments.projectmanager.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
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

    //get a user by email
    public User getUser(String email) {
		Optional<User> potentialUser = userRepository.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}

    //create a user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //get all users
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    //get a user
    public User getUser(Long id) {
        Optional<User> potentialUser = userRepository.findById(id);
        return potentialUser.isPresent() ? potentialUser.get() : null;
    }

    //update a user
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    //delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
