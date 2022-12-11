package com.assignments.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.assignments.bookclub.models.User;
import com.assignments.bookclub.models.UserLogin;
import com.assignments.bookclub.repositories.UserRepository;

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
	
	public User getUser(String email) {
		Optional<User> potentialUser = userRepository.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
	
	public User getUser(Long id) {
		Optional<User> potentialUser = userRepository.findById(id);
		return potentialUser.isPresent() ? potentialUser.get() : null;
	}
}