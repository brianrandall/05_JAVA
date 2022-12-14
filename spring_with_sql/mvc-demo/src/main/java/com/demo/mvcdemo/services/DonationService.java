package com.demo.mvcdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.mvcdemo.models.Donation;
import com.demo.mvcdemo.models.User;
import com.demo.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    //create a donation
    public Donation create(Donation donation) {
        return donationRepository.save(donation);
    }

    //get all donations
    public List<Donation> findAllDonations() {
        return donationRepository.findAll();
    }

    //search for donations containing a string
    public List<Donation> searchDonations(String search) {
        return donationRepository.findByDonationNameContaining(search);
    }

    //get one donation
    public Donation findOneDonation(Long id) {
        return donationRepository.findById(id).orElse(null);
    }

    //update a donation
    public Donation update(Long id, String donationName, User donorName, Integer quantity) {
        Donation donation = findOneDonation(id);
        donation.setDonationName(donationName);
        donation.setDonorName(donorName);
        donation.setQuantity(quantity);
        return donationRepository.save(donation);
    }

    public Donation update(Donation donation) {
        return donationRepository.save(donation);
    }

    //delete a donation
    public void delete(Long id) {
        donationRepository.deleteById(id);
    }

}
