package com.demo.mvcdemo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mvcdemo.models.User;
import com.demo.mvcdemo.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newUser(
        @ModelAttribute("user") User user) {
        return "user/create.jsp";
    }

    @PostMapping("/new")
    public String processNewUser(
        @Valid
        @ModelAttribute("user") User user, 
        BindingResult result) {
            if (result.hasErrors()) {
                return "user/create.jsp";
            } else {
                userService.create(user);
                return "redirect:/users/new";
            }
        }

}
