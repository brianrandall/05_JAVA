package com.brian.twitterlite.services;

import org.springframework.stereotype.Service;

import com.brian.twitterlite.models.User;
import com.brian.twitterlite.models.UserFollowing;
import com.brian.twitterlite.repositories.UserFollowingRepository;
import com.brian.twitterlite.repositories.UserRepository;

@Service
public class UserFollowingService {
    private final UserFollowingRepository userFollowingRepository;
    private final UserRepository userRepository;
    public UserFollowingService(UserFollowingRepository userFollowingRepository, UserRepository userRepository) {
        this.userFollowingRepository = userFollowingRepository;
        this.userRepository = userRepository;
    }

    public UserFollowing createFollow(UserFollowing follow) {
        return userFollowingRepository.save(follow);
    }

    //create a follow
    // public UserFollowing addFollow(Long user_id, Long following_id) {
    //     return userFollowingRepository.createFollow(following_id, user_id);
    // }

    //find the one to delete
    public Long find(Long user_id, Long following_id) {
       return userFollowingRepository.find(user_id, following_id);
    }

    public void deleteFollow(Long x) {
        userFollowingRepository.deleteById(x);
    }

    //make this stupid thing work 

    
}
