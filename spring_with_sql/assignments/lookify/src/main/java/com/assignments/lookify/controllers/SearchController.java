package com.assignments.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.lookify.models.Song;
import com.assignments.lookify.services.SongService;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SongService songService;
    public SearchController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String searchSongs(
        @ModelAttribute("song") Song song,
        @RequestParam("search") String search, 
        Model model,
        @ModelAttribute("error") String error) {
        model.addAttribute("song", songService.searchArtists(search));
        if (songService.searchArtists(search).isEmpty()) {
            model.addAttribute("error", search +" not found.");
            model.addAttribute("song", songService.allSongs());
            return "dashboard.jsp";
        } else {
            return "dashboard.jsp";
        }

        
    }

    @GetMapping("/top-ten")
    public String topTen(
        @ModelAttribute("song") Song song, 
        Model model) {
        model.addAttribute("song", songService.topTenSongs());
        return "topTen.jsp";
    }
    
}
