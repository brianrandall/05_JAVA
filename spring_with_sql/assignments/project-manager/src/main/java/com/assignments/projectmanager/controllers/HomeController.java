package com.assignments.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignments.projectmanager.models.User;
import com.assignments.projectmanager.models.UserLogin;
import com.assignments.projectmanager.services.ProjectService;
import com.assignments.projectmanager.services.UserService;

@Controller
public class HomeController {

    private final UserService userService;
    private final ProjectService projectService;
    public HomeController(UserService userService, ProjectService projectService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(
    HttpSession session,
    Model model) {
    if(session.getAttribute("user_id") != null) {
        return "redirect:/dashboard";
    }
    model.addAttribute("newUser", new User());
    model.addAttribute("loginUser", new UserLogin());
        return "/home/login-reg.jsp";
    }

    @PostMapping("/register")
	public String registerUser(
        @Valid 
        @ModelAttribute("newUser") User user, 
        BindingResult result, 
        HttpSession session, 
        Model model) {
		// check if the passwords match
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			result.rejectValue("password", "Match" ,"passwords not matching");
		}
		// check if the email already exists
		if(userService.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique" ,"Email already exists");
		}
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new UserLogin());
			return "/home/login-reg.jsp";
		}
		User newUser = userService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String loginUser(
        @Valid 
        @ModelAttribute("loginUser") UserLogin userLogin, 
        BindingResult result, 
        Model model, 
        HttpSession session) {
		User loggingInUser = userService.login(userLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/home/login-reg.jsp";
		}
		session.setAttribute("user_id", loggingInUser.getId());
		return "redirect:/dashboard";
	}

    @GetMapping("/dashboard")
    public String dashboard(
        HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Long userId = (Long) session.getAttribute("user_id");
        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        model.addAttribute("unassignedProjects", projectService.allUnassignedProjects(user));
        model.addAttribute("myProjects", projectService.myProjects(user));
        
        return "/dashboard/index.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}