package com.brian.twitterlite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.twitterlite.models.Post;
import com.brian.twitterlite.models.User;
import com.brian.twitterlite.repositories.PostRepository;
import com.brian.twitterlite.repositories.UserRepository;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //create a post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    //get all posts
    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    //get all posts by user and users they follow
    public List<Post> allPostsByUserAndFollowing(Long id) {
        return postRepository.findPostsByUserAndFollowing(id);
    }

    //find all posts by username
    public List<Post> allPostsByUsername(String username) {
        //get user id by username
        User user = userRepository.findByUsername(username);
        return postRepository.findByUser(user.getId());
    }


    //get one post
    public Post getOnePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            return null;
        }
    }

    //delete a post
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
