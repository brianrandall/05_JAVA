package com.assignments.projectmanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.projectmanager.models.Task;
import com.assignments.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //get all tasks
    public List<Task> allTasks(){
        return taskRepository.findAll();
    }

    //get all tasks by project
    public List<Task> allTasksByProject(Long project){
        return taskRepository.findByProjectIdIs(project);
    }

    //create a task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    //delete a task
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
    
}
