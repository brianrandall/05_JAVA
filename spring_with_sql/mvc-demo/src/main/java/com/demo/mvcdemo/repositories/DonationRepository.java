package com.demo.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.mvcdemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
    List<Donation> findAll();
    List<Donation> findByDonationNameContaining(String search);

}
    

