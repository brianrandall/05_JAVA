package com.daikichi.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiRoutes {
    
    @GetMapping("")
    public String index() {
        return "Welcome!";
    }

    @GetMapping("/today")
    public String today() {
        return "Today you will find luck in all your endeavors!";
    }

    @GetMapping("/tomorrow")
    public String tomorrow() {
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

}
