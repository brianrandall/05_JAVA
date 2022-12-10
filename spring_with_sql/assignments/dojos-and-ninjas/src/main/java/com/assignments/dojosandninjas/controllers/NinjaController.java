package com.assignments.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojosandninjas.models.Ninja;
import com.assignments.dojosandninjas.services.DojoService;
import com.assignments.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;
    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("/new")
    public String newNinja(
        @ModelAttribute("ninja") Ninja ninja,
        Model model) {
        model.addAttribute("dojos", dojoService.getAllDojos());
        return "ninja/new.jsp";
    }

    @PostMapping("/new")
    public String processNewNinja(
        @Valid
        @ModelAttribute("ninja") Ninja ninja,
        BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("dojos", dojoService.getAllDojos());
            return "ninja/new.jsp";
        } else {
            model.addAttribute("dojo", dojoService.getDojo(ninja.getDojo().getId()));
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojo().getId() + "";
        }
    }    
}
