package com.brian.twitterlite.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.groups.Default;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brian.twitterlite.models.Post;
import com.brian.twitterlite.models.User;
import com.brian.twitterlite.models.UserLogin;
import com.brian.twitterlite.services.PostService;
import com.brian.twitterlite.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
    private final UserService userService;
    private final PostService postService;
    public ApiController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/users/email/{email}")
    public User searchForEmail(
        @PathVariable("email") String email
    ) {
        return userService.getUser(email); 
    }

    @GetMapping("/users/username/{username}")
    public User searchForUsername(
        @PathVariable("username") String username
    ) {
        return userService.getUsername(username);
    }

    


    @PostMapping("/users/register")
    public String registerNewUser(
    @RequestBody User user,
    @Valid 
    BindingResult result, 
    HttpSession session, 
    Model model) {
    
    System.out.println(user.getEmail());
    // check if the passwords match
    if(!user.getPassword().equals(user.getPasswordConfirmation())) {
        result.rejectValue("password", "Match" ,"passwords not matching");
    }
    if(!user.getPassword().equals(user.getPasswordConfirmation())) {
        result.rejectValue("password", "Match" ,"passwords not matching");
    }
    // check if the email already exists
    if(userService.getUser(user.getEmail()) != null) {
        result.rejectValue("email", "Unique" ,"Email already exists");
    }
    // if result has errors, set results to error
    if(result.hasErrors()) {
        return result.toString();
    }
    // if the user is valid, save them in the database, save the user id in session
    userService.registerUser(user);
    session.setAttribute("user_id", user.getId());
    return "user has been created";
    }


    @PostMapping("/users/login")
	public ResponseEntity<String> loginUser (
        @Valid 
        @RequestBody UserLogin userLogin,
        BindingResult result,
        Model model, 
        HttpSession session) {
		User loggingInUser = userService.login(userLogin, result);
		if(result.hasErrors()) {
			return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
		}
		session.setAttribute("user_id", loggingInUser.getId());
		return new ResponseEntity<>("goooooood", HttpStatus.OK);
	}


    // @PostMapping("/posts/{username}")
    // public ResponseEntity<String> createPost(
    //     @RequestBody Post newPost,
    //     BindingResult result,
    //     @RequestParam("username") String username,
    //     @ModelAttribute("post") Post post,
    //     Model model
    //     ) {
    //     if(result.hasErrors()) {
    //         return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
    //     }
    //     User user = userService.getUsername(username);
    //     newPost.setPoster(user);
    //     postService.createPost(newPost);
    //     return new ResponseEntity<>("good", HttpStatus.OK);
    // }

    //post a post to a user
    @PostMapping("/posts/{username}")
    public ResponseEntity<String> createPost(
        @RequestBody Post newPost,
        BindingResult result,
        @PathVariable("username") String username,
        @ModelAttribute("post") Post post,
        Model model
        ) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
        }
        User user = userService.getUsername(username);
        newPost.setPoster(user);
        postService.createPost(newPost);
        return new ResponseEntity<>("good", HttpStatus.OK);
    }

    
}
