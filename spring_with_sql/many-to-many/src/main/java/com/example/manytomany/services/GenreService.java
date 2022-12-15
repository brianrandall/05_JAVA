package com.example.manytomany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.manytomany.models.Genre;
import com.example.manytomany.repositories.GenreRepo;

@Service
public class GenreService {
    private final GenreRepo genreRepo;
    public GenreService(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    //create a genre
    public void createGenre(Genre genre) {
        genreRepo.save(genre);
    }

    //get one genre by id
    public Genre getGenre(Long id) {
        return genreRepo.findById(id).orElse(null);
    }

    public Genre getGenre(String genreName) {
        return genreRepo.findByTitle(genreName).orElse(null);
    }

    //get all genres
    public List<Genre> getAllGenres() {
        return genreRepo.findAll();
    }

    //update a genre
    public void updateGenre(Genre genre) {
        genreRepo.save(genre);
    }

    //delete a genre
    public void deleteGenre(Long id) {
        genreRepo.deleteById(id);
    }
}
