package com.example.travelwithloginandreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.travelwithloginandreg.models.Destination;
import com.example.travelwithloginandreg.services.DestinationService;

@Controller
@RequestMapping("/destinations")
public class DestinationController {
    private final DestinationService destinationService;
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/create")
    public String createDestination(
        @ModelAttribute("destination") Destination destination,
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/users/login/register";
        }
        return "destination/create.jsp";
    }

    @PostMapping("/create")
    public String processDestination(
        @Valid
        @ModelAttribute("destination") Destination destination,
        BindingResult result) {
        if(result.hasErrors()) {
            return "destination/create.jsp";
        }

        destinationService.createDestination(destination);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editDestination(
        @PathVariable("id") Long id,
        Model model,
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/users/login/register";
        }
        model.addAttribute("destination", destinationService.getDestination(id));
        return "destination/edit.jsp";
    }

    @PutMapping("/edit/{id}")
    public String processEditDestination(
        @PathVariable("id") Long id,
        @Valid
        @ModelAttribute("destination") Destination destination,
        BindingResult result) {
        if(result.hasErrors()) {
            return "destination/edit.jsp";
        }
        destinationService.updateDestination(destination);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteDestination(
        @PathVariable("id") Long id) {
        destinationService.deleteDestination(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showDestination(
        @PathVariable("id") Long id,
        Model model
        ) {
        model.addAttribute("destination", destinationService.getDestination(id));
        return "destination/view.jsp";
    }

}
