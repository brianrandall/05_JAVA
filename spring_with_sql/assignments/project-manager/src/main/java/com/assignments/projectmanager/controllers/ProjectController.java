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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.projectmanager.models.Project;
import com.assignments.projectmanager.models.User;
import com.assignments.projectmanager.services.ProjectService;
import com.assignments.projectmanager.services.TaskService;
import com.assignments.projectmanager.services.UserService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;
    public ProjectController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/new")
    public String newProject(
        @ModelAttribute("project") Project project,
        Model model,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            return "project/add.jsp";
    }

    @PostMapping("/new")
    public String processNewProject(
        @Valid
        @ModelAttribute("project") Project project,
        BindingResult result,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            if (result.hasErrors()) {
                return "project/add.jsp";
            }
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            projectService.createProject(project);
            user.getProjects().add(project);
            userService.updateUser(user);
            return "redirect:/dashboard";
    }

    @RequestMapping("/join/{id}")
    public String joinProject(
        @PathVariable("id") Long id,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            Project project = projectService.findProject(id);
            user.getProjects().add(project);
            userService.updateUser(user);
            return "redirect:/dashboard";
    }

    @RequestMapping("/leave/{id}")
    public String leaveProject(
        @PathVariable("id") Long id,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            Project project = projectService.findProject(id);
            user.getProjects().remove(project);
            userService.updateUser(user);
            return "redirect:/dashboard";
    }

    @GetMapping("/edit/{id}")
    public String editProject(
        @PathVariable("id") Long id,
        @ModelAttribute("project") Project project,
        Model model,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            Project projectToEdit = projectService.findProject(id);
            model.addAttribute("project", projectToEdit);
            return "project/edit.jsp";
    }

    @PutMapping("/edit/{id}")
    public String processEditProject(
        @PathVariable("id") Long id,
        @Valid
        @ModelAttribute("project") Project project,
        BindingResult result,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            if (result.hasErrors()) {
                return "project/edit.jsp";
            }
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            projectService.updateProject(project);
            user.getProjects().add(project);
            userService.updateUser(user);
            return "redirect:/dashboard";
    }

    @GetMapping("/{id}")
    public String showProject(
        @PathVariable("id") Long id,
        Model model,
        HttpSession session) {
            if (session.getAttribute("user_id") == null) {
                return "redirect:/";
            }
            Long user_id = (Long) session.getAttribute("user_id");
            userService.getUser(user_id);
            Project project = projectService.findProject(id);
            model.addAttribute("project", project);
            model.addAttribute("tasks", taskService.allTasksByProject(id));
            return "project/view.jsp";
    }
}
