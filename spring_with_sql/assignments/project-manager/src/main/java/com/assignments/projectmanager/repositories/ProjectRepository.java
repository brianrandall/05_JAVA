package com.assignments.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignments.projectmanager.models.Project;
import com.assignments.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
 
    List<Project> findAll();
    Project findByIdIs(Long id);
    List<Project> findAllByUsers(User user);
    List<Project> findAllByUsersNotContains(User user);

}
