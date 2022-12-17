package com.brian.twitterlite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brian.twitterlite.models.Post;
import com.brian.twitterlite.repositories.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //create a post
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    //get all posts
    public List<Post> allPosts() {
        return postRepository.findAll();
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
