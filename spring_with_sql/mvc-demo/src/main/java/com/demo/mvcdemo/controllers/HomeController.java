package com.demo.mvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.mvcdemo.services.DonationService;
import com.demo.mvcdemo.services.UserService;

@Controller
public class HomeController {
    
    private final DonationService donationService;
    private final UserService userService;

    public HomeController(DonationService donationService, UserService userService) {
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "main/dashboard.jsp";
    }

}
