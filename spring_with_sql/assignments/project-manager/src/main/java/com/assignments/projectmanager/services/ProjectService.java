package com.assignments.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.projectmanager.models.Project;
import com.assignments.projectmanager.models.User;
import com.assignments.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
   private final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //create a project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    //get all projects
    public List<Project> allProjects(){
        return projectRepository.findAll();
    }

    //get all assigned users projects
    public List<Project> myProjects(User user){
        return projectRepository.findAllByUsers(user);
    }

    //get all unassigned projects
    public List<Project> allUnassignedProjects(User user){
        return projectRepository.findAllByUsersNotContains(user);
    }

    //get a project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }

    //update a project
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    //delete a project
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
