package com.example.travelwithloginandreg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.travelwithloginandreg.services.DestinationService;
import com.example.travelwithloginandreg.services.UserService;

@Controller
public class MainController {
    private final UserService userService;
    private final DestinationService destinationService;
    public MainController(UserService userService, DestinationService destinationService) {
        this.userService = userService;
        this.destinationService = destinationService;
    }
    
    @GetMapping("/")
    public String dashboard(
        HttpSession session,
        Model model) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/users/login/register";
        }
        model.addAttribute("destinations", destinationService.allDestinations());
        model.addAttribute("loggedInUser", userService.getUser((Long)session.getAttribute("user_id")));
        return "main/dashboard.jsp";
    }
}
