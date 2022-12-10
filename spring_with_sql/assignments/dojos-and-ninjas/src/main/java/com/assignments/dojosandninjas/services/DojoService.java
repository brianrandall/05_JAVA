package com.assignments.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.dojosandninjas.models.Dojo;
import com.assignments.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    //create a dojo
    public void createDojo(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    //get one dojo by id
    public Dojo getDojo(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }

    //get all dojos
    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    //get all dojos by order of most recently created
    public List<Dojo> getAllDojosOrderByCreatedAtDesc() {
        return dojoRepository.findAllByOrderByCreatedAtDesc();
    }

    //update a dojo
    public void updateDojo(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    //delete a dojo
    public void deleteDojo(Long id) {
        dojoRepository.deleteById(id);
    }

}
