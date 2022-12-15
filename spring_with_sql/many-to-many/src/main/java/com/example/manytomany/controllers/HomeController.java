package com.example.manytomany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.manytomany.services.GameService;

@Controller
public class HomeController {
    private final GameService gameService;
    public HomeController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String dashboarddddd(Model model) {
        model.addAttribute("allGames", gameService.getAllGames());
        return "main/dashboard.jsp";
    }
}
