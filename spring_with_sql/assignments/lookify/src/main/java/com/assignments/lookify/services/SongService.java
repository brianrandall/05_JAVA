package com.assignments.lookify.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.lookify.models.Song;
import com.assignments.lookify.repositories.SongRepository;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    //create new song
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    //get all songs
    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    //search songs by artist
    public List<Song> searchArtists(String search) {
        return songRepository.findByArtistContaining(search);
    }

    //search songs by artist or title
    public List<Song> searchTitleOrArtist(String search) {
        List<Song> output = new ArrayList<Song>();
        List<Song> title = songRepository.findByTitleContaining(search);
        List<Song> artist = songRepository.findByArtistContaining(search);
        for(Song song : title){
            output.add(song);
        }
        for(Song song : artist){
            output.add(song);
        }
        return output;
    }

    //also search by artist or title
    public List<Song> searchArtistOrTitle(String search) {
        return songRepository.findByTitleOrArtist(search, search);
    }

    //get top 10 songs
    public List<Song> topTenSongs() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }

    //get one song
    public Song findOneSong(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    //delete song
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }


    
}
