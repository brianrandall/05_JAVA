package com.brian.routesspringdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("name", "Bugs Bunny");
        return "index.jsp";
    }

    @GetMapping("/java/demo")
    public String demo() {
        return "demo.jsp";
    }

    @GetMapping("/jstl/demo")
    public String jstilDemo(Model model) {

        String name = "brian randall";
        Integer age = 33;
        Boolean isHungry = true;
        ArrayList<String> users = new ArrayList<String>();

        model.addAttribute("nameFromController", name);
        model.addAttribute("ageFromController", age);
        model.addAttribute("isHungryFromController", isHungry);
        model.addAttribute("usersFromController", users);

        users.add("brian");
        users.add("other brian");
        users.add("evil brian");
        users.add("happy brian");
        users.add("sad brian");


        return "JSTLdemo.jsp";
    }
}