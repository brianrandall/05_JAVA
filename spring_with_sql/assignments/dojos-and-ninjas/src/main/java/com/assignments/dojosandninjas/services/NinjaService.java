package com.assignments.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.dojosandninjas.models.Ninja;
import com.assignments.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //create a ninja
    public void createNinja(Ninja ninja) {
        ninjaRepository.save(ninja);
    }

    //get all ninjas
    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    //get all ninjas with a specific dojo_id
    public List<Ninja> getAllNinjasWithDojoId(Long id) {
        return ninjaRepository.findByDojoId(id);
    }
}
