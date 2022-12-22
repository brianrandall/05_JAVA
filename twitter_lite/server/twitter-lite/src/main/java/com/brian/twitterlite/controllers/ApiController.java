package com.brian.twitterlite.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brian.twitterlite.models.Post;
import com.brian.twitterlite.models.PostComment;
import com.brian.twitterlite.models.User;
import com.brian.twitterlite.models.UserLogin;
import com.brian.twitterlite.services.PostCommentService;
import com.brian.twitterlite.services.PostService;
import com.brian.twitterlite.services.UserService;
import com.github.javafaker.Faker;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {
    private final UserService userService;
    private final PostService postService;
    private final PostCommentService postCommentService;
    public ApiController(UserService userService, PostService postService, PostCommentService postCommentService) {
        this.userService = userService;
        this.postService = postService;
        this.postCommentService = postCommentService;
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

    @GetMapping("/users/search/{search}")
    public List<User> searchForUsers(
        @PathVariable("search") String search
    ) {
        return userService.searchUsers(search);
    }

    @GetMapping("/users/{id}")
    public User searchForId(
        @PathVariable("id") Long id
    ) {
        return userService.findUserById(id);
    }


    @GetMapping("/users/fake/lots/of/users")
    public String fakeUsers(
        @ModelAttribute("user") User user
    ) {
        for (int i = 0; i < 20; i++) {

            Faker faker = new Faker();
            User newUser = new User();

            newUser.setAdmin(false);
            newUser.setFirstName(faker.name().firstName());
            newUser.setLastName(faker.name().lastName());
            newUser.setBio(faker.commerce().productName());
            newUser.setEmail(faker.internet().emailAddress());
            newUser.setLocation(faker.address().cityName());
            newUser.setPassword("Password1!");
            newUser.setPasswordConfirmation("Password1!");
            newUser.setUsername(faker.ancient().hero());
            userService.registerUser(newUser);
        }
        return "fake users created";
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

    @PostMapping("/posts/{id}/comment")
    public ResponseEntity<String> createComment(
        @PathVariable ("id") Post id,
        @RequestBody PostComment newComment,
        BindingResult result
        ) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("bad", HttpStatus.BAD_REQUEST);
        }
        newComment.setPost(id);
        postCommentService.createComment(newComment);
        return new ResponseEntity<>("good", HttpStatus.OK);
    }

    @PostMapping("/posts/{id}/favorite/{user_id}")
    public Post addFavorite(
        @PathVariable ("id") Post id,
        @PathVariable ("user_id") User user_id
        ) {
        Long userId = (Long) user_id.getId();
        Long postId = (Long) id.getId();
        return postService.addFavorite(userId, postId);
    }


    // //add a favorite to a post
    // public Post addFavorite(Long user_id, Long post_id) {
    //     Post post = postRepository.findById(post_id).orElse(null);
    //     User user = userRepository.findById(user_id).orElse(null);
    //     List<User> list_of_favorites = post.getUsers_who_favorited();
    //     if (list_of_favorites.contains(user)) {
    //         return null;
    //     } else {
    //         list_of_favorites.add(user);
    //         post.setUsers_who_favorited(list_of_favorites);
    //         return postRepository.save(post);
    //     }
    // }

    @GetMapping("/posts/{username}")
    public List<Post> getPosts(
        @PathVariable("username") String username
    ) {
        return postService.allPostsByUsername(username);
    }

    // @GetMapping("/posts/{id}/{user_id}")
    // public Post getOnePost(
    //     @PathVariable("id") Long id,
    //     @PathVariable("username") String username
    // ) {
    //     Post post = postService.getOnePost(id);
    //     User user = userService.getUsername(username);
    //     post.setPoster(user);
    //     return post;
    // }

    @GetMapping("/posts/one/{id}")
    public Post getOnePost(
        @PathVariable("id") Long id
    ) {
        Post post = postService.getOnePost(id);
        return post;
    }

    // get all posts from all users
    @GetMapping("/posts/all")
    public List<Post> getAllPosts() {
        return postService.allPosts();
    }

    @GetMapping("/posts/all/{id}/following")
    public List<Post> getAllPostsFromFollowing(
        @PathVariable("id") Long id
    ) {
        List<Post> posts = postService.allPostsByUserAndFollowing(id);

        return posts;
    }
}

