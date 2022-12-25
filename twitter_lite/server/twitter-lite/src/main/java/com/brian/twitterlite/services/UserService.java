package com.brian.twitterlite.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brian.twitterlite.models.User;
import com.brian.twitterlite.models.UserFollowing;
import com.brian.twitterlite.models.UserLogin;
import com.brian.twitterlite.repositories.PostRepository;
import com.brian.twitterlite.repositories.UserFollowingRepository;
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

    //search users by username
    public List<User> searchUsers(String username) {
        return userRepository.findByUsernameContaining(username);
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

    //find user by id and update
    public User updateUserById(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setAdmin(user.getAdmin());
        return userRepository.save(userToUpdate);
    }

    //add follower to user
    public User addFollower(User user_id, Long follower_id) {
        User user = userRepository.findByIdIs(user_id.getId());
        UserFollowing follow = new UserFollowing();
        follow.setFollowingId(follower_id);
        follow.setUser(user_id);
        List<UserFollowing> list_of_followers = user.getFollowings();
        if (list_of_followers.contains(user) && list_of_followers.contains(follow)) {
            return null;
        } else {
            list_of_followers.add(follow);
            user.setFollowings(list_of_followers);
            return userRepository.save(user);
        }
    }

    //delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
