package com.example.manytomany.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.manytomany.models.Genre;

@Repository
public interface GenreRepo extends CrudRepository<Genre, Long>{
    List<Genre> findAll();
    Optional<Genre> findByTitle(String genre);
}
