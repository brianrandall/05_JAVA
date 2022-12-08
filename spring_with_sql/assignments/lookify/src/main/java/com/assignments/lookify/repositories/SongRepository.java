package com.assignments.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
    List<Song> findAll();
    List<Song> findByArtistContaining(String search);
    List<Song> findByTitleContaining(String search);
    List<Song> findByTitleOrArtist(String search, String search2);
    List<Song> findTop10ByOrderByRatingDesc();
}
