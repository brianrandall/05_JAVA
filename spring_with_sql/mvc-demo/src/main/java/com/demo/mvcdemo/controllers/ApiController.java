package com.demo.mvcdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mvcdemo.models.Donation;
import com.demo.mvcdemo.models.User;
import com.demo.mvcdemo.services.DonationService;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    public final DonationService donationService;

    public ApiController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/donations")
    public List<Donation> findAllDonations() {
        return donationService.findAllDonations();
    }

    @PostMapping("/donations")
    public Donation createDonation(
        @RequestParam("donationName") String donationName,
        @RequestParam("donorName") User donorName,
        @RequestParam("quantity") Integer quantity
    ) {
        Donation newDonation = new Donation(donorName, donationName, quantity);
        return donationService.create(newDonation);
    }

    @GetMapping("/donations/{id}")
    public Donation findOneDonation(@PathVariable("id") Long id) {
        return donationService.findOneDonation(id);
    }

    @PutMapping("/donations/{id}")
    public Donation updateDonation(
        @PathVariable("id") Long id,
        @RequestParam("donationName") String donationName,
        @RequestParam("donorName") User donorName,
        @RequestParam("quantity") Integer quantity
    ) {
        return donationService.update(id, donationName, donorName, quantity);
    }

    //delete a donation
    @DeleteMapping("/donations/{id}")
    public void deleteDonation(@PathVariable("id") Long id) {
        donationService.delete(id);
    }
}
