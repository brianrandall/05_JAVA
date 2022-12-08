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

import com.assignments.lookify.models.Song;
import com.assignments.lookify.services.SongService;

@Controller
public class SongController {
    private final SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
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
