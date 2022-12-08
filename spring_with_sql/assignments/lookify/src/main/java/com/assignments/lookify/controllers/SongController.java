package com.assignments.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.lookify.models.Song;
import com.assignments.lookify.services.SongService;

@Controller
public class SongController {
    private final SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }

    @GetMapping("/dashboard")
    public String dashboard(
        @ModelAttribute("song") Song song, Model model) {
        model.addAttribute("song", songService.allSongs());
        return "dashboard.jsp";
    }

    @GetMapping("/search/")
    public String searchSongs(
        @ModelAttribute("song") Song song,
        @RequestParam("search") String search, 
        Model model) {
        model.addAttribute("song", songService.searchArtists(search));
        return "dashboard.jsp";
    }

    @GetMapping("/search/top-ten")
    public String topTen(
        @ModelAttribute("song") Song song, 
        Model model) {
        model.addAttribute("song", songService.topTenSongs());
        return "topTen.jsp";
    }

    @GetMapping("/songs/{id}")
    public String showSong(
        Model model,
        @PathVariable("id") Long id 
        ) {
        model.addAttribute("song", songService.findOneSong(id));
        return "displaySongInfo.jsp";
    }

    @GetMapping("/songs/new")
    public String newSong(
        @ModelAttribute("song") Song song
    ) {
        return "newSong.jsp";
    }

    @PostMapping("/songs/new")
    public String newSongProcess(
        @Valid @ModelAttribute("song") Song song, 
        BindingResult result) {
        if (result.hasErrors()) {
            return "newSong.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }

    @DeleteMapping("/songs/{id}")
    public String deleteSong(
        @PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
        }
    
}
