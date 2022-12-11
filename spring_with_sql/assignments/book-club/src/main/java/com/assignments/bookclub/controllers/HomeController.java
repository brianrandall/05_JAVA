package com.assignments.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignments.bookclub.models.User;
import com.assignments.bookclub.models.UserLogin;
import com.assignments.bookclub.services.UserService;

@Controller
public class HomeController {

    private final UserService userService;
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(
    HttpSession session,
    Model model) {
    if(session.getAttribute("user_id") != null) {
        return "redirect:/books";
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
		return "redirect:/books";
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
		return "redirect:/books";
	}

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}