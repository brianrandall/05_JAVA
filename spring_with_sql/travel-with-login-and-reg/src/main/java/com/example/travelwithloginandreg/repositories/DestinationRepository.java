package com.example.travelwithloginandreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.travelwithloginandreg.models.Destination;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Long>{
    List<Destination> findAll();
}
