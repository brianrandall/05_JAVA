package com.assignments.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignments.projectmanager.models.Project;
import com.assignments.projectmanager.models.Task;
import com.assignments.projectmanager.models.User;
import com.assignments.projectmanager.services.ProjectService;
import com.assignments.projectmanager.services.TaskService;
import com.assignments.projectmanager.services.UserService;

@Controller
public class TaskController {
    public final TaskService taskService;
    public final ProjectService projectService;
    public final UserService userService;
    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/projects/{id}/tasks")
    public String viewProjectTasks(
        @PathVariable("id") Long id,
        @ModelAttribute("task") Task task,
        Model model,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
           
            Project project = projectService.findProject(id);
            model.addAttribute("project", project);
            model.addAttribute("tasks", taskService.allTasksByProject(id));
            return "project/project-tasks.jsp";
    }

    @PostMapping("/projects/{id}/tasks")
    public String processProjectTasks(
        @PathVariable("id") Long id,
        Model model,
        @Valid
        @ModelAttribute("task") Task task,
        BindingResult result,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            if (result.hasErrors()) {
                session.getAttribute("user_id");
                model.addAttribute("project", projectService.findProject(id));
                model.addAttribute("tasks", taskService.allTasksByProject(id));
                return "project/project-tasks.jsp";
            }
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            task.setProject(projectService.findProject(id));
            task.setCreator(userService.getUser((Long) session.getAttribute("user_id")));
            taskService.createTask(task);
            userService.updateUser(user);
            return "redirect:/projects/" + id + "/tasks";
    }
}
