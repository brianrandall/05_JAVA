package com.demo.mvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
