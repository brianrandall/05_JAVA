package com.demo.mvcdemo.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.mvcdemo.models.Donation;
import com.demo.mvcdemo.services.DonationService;

@Controller
@RequestMapping("/donations")
public class DonationController {

    public final DonationService donationService;
    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/all")
    public String allDonations(Model model) {
        model.addAttribute("allDonations", donationService.findAllDonations());
        return "showAll.jsp";
    }

    @GetMapping("/show-one/{id}")
    public String oneDonation(Model model, @PathVariable("id") Long id) {
        model.addAttribute("oneDonation", donationService.findOneDonation(id));
        return "showOne.jsp";
    }

    @GetMapping("/new-donation")
    public String newDonation(@ModelAttribute("donation") Donation donation) {
        return "newDonation.jsp";
    }

    @PostMapping("/process")
    public String processDonation(
        @Valid 
        @ModelAttribute("donation") Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "editDonation.jsp";
        } else {
            donationService.create(donation);
            return "redirect:/donations/all";
        }
    }

    @GetMapping("/edit/{id}")
    public String editDonation(
        @PathVariable("id") Long id, Model model) {
        Donation donationToBeEdited = donationService.findOneDonation(id);
        if (donationToBeEdited != null) {
            model.addAttribute("donation", donationToBeEdited);
            return "editDonation.jsp";
        } else {
            return "redirect:/donations/all";
        }
    }

    @PutMapping("/edit/process/{id}")
    public String processEditDonation(
        @PathVariable("id") Long id, 
        @Valid 
        @ModelAttribute("donation") Donation donation, 
        BindingResult result) {
        if (result.hasErrors()) {
            return "editDonation.jsp";
        } else {
            donationService.update(donation);
            return "redirect:/donations/all";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDonation(@PathVariable("id") Long id) {
        donationService.delete(id);
        return "redirect:/donations/all";
    }

    @GetMapping("/search")
    public String searchDonations(
        @RequestParam("searchTerm") String search, Model model) {
        model.addAttribute("allDonations", donationService.searchDonations(search));
        return "showAll.jsp";
    }


}
