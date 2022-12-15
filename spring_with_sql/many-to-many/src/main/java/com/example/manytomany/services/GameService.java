package com.example.manytomany.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.manytomany.models.Game;
import com.example.manytomany.models.Genre;
import com.example.manytomany.repositories.GameRepo;
import com.example.manytomany.repositories.GenreRepo;

@Service
public class GameService {
    private final GameRepo gameRepo;
    private final GenreRepo genreRepo;
    public GameService(GameRepo gameRepo, GenreRepo genreRepo) {
        this.gameRepo = gameRepo;
        this.genreRepo = genreRepo;
    }

    //create a game
    public void createGame(Game game) {
        gameRepo.save(game);
    }

    //checks to see if genre is in database already, if not, creates it
    public Genre createGenreIfNotInDb(String genre) {
        if(getGenre(genre) == null) {
            Genre newGenre = new Genre();
            newGenre.setTitle(genre);
            return genreRepo.save(newGenre);
        }
        return getGenre(genre);
    }
    //create game with genre
    public Game createGameWithGenre(Game game) {
        String[] genresFromForm = game.getFormGenres().split(",");
        ArrayList<Genre> genresToBeAdded = new ArrayList<Genre>();
        for(String genre : genresFromForm) {
            genresToBeAdded.add(createGenreIfNotInDb(genre));
        }
        game.setGenres(genresToBeAdded);
        return gameRepo.save(game);
    }

    //get one genre by name
    public Genre getGenre(String genreName) {
        return genreRepo.findByTitle(genreName).orElse(null);
    }

    //get one game by id
    public Game getGame(Long id) {
        return gameRepo.findById(id).orElse(null);
    }
    

    //get all games
    public List<Game> getAllGames() {
        return gameRepo.findAll();
    }

    //update a game
    public void updateGame(Game game) {
        gameRepo.save(game);
    }

    //delete a game
    public void deleteGame(Long id) {
        gameRepo.deleteById(id);
    }
}
