package com.example.travelwithloginandreg.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.travelwithloginandreg.models.Destination;
import com.example.travelwithloginandreg.repositories.DestinationRepository;

@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }
    
    //create destination
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    //get all destinations
    public List<Destination> allDestinations() {
        return destinationRepository.findAll();
    }

    //get one destination
    public Destination getDestination(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

    //update destination
    public Destination updateDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    //delete destination
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
