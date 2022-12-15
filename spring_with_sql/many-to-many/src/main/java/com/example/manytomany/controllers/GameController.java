package com.example.manytomany.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.manytomany.models.Game;
import com.example.manytomany.services.GameService;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("/create")
    public String createGame(
        @ModelAttribute("game") Game game
    ) {
        return "games/create.jsp";
    }

    @PostMapping("/create")
    public String processCreateGame(
        @Valid
        @ModelAttribute("game") Game game,
        BindingResult result
    ) {
        if (result.hasErrors()) {
            return "games/create.jsp";
        }
        gameService.createGameWithGenre(game);
        return "redirect:/";
    }
    
}
