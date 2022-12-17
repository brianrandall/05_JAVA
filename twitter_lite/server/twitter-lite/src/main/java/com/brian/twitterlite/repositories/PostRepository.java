package com.brian.twitterlite.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.twitterlite.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
    List<Post> findAll();
    Post findByIdIs (Long id);
}
