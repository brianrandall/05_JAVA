package com.assignments.lookify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.assignments.lookify.models.Song;
import com.assignments.lookify.services.SongService;


@Controller
public class HomeController {
    private final SongService songService;
    public HomeController(SongService songService) {
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
    
}
