package com.assignments.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.assignments.dojosandninjas.services.DojoService;
import com.assignments.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;
    public HomeController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    
    @GetMapping("/")
    public String index() {
        return "redirect:/dojos/new";
    }

    @GetMapping("/every-ninja-in-every-dojo-in-the-entire-world")
    public String allNinjas (
        Model model
    ) {
        model.addAttribute("ninjas", ninjaService.getAllNinjas());
        model.addAttribute("dojos", dojoService.getAllDojos());
        return "all.jsp";
    }

}
