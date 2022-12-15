package com.example.manytomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.manytomany.models.Game;

@Repository
public interface GameRepo extends CrudRepository<Game, Long>{
    List<Game> findAll();
    
}
