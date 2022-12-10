package com.assignments.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojosandninjas.models.Dojo;
import com.assignments.dojosandninjas.services.DojoService;
import com.assignments.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
    private final DojoService dojoService;
    private final NinjaService ninjaService;
    public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
    
    @GetMapping("/new")
    public String newDojo(
        @ModelAttribute("dojo") Dojo dojo){
        return "dojo/new.jsp";
    }

    @PostMapping("/new")
    public String processNewDojo(
        @Valid
        @ModelAttribute("dojo") Dojo dojo,
        BindingResult result
    ) {
        if (result.hasErrors()) {
            return "dojo/new.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }

    @GetMapping("/{id}")
    public String showAllNinjasInDojo(
        @PathVariable("id") Long id,
        @ModelAttribute("dojo") Dojo dojo,
        Model model

    ) {
        model.addAttribute("dojo", dojoService.getDojo(id));
        model.addAttribute("ninjas", ninjaService.getAllNinjasWithDojoId(id));
        return "dojo/allNinjasInDojo.jsp";
    }

}
