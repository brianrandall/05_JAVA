package com.assignments.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.bookclub.models.Book;
import com.assignments.bookclub.models.User;
import com.assignments.bookclub.services.BookService;
import com.assignments.bookclub.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("")
    public String booksHome(Model model, HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = userService.getUser(user_id);
        model.addAttribute("user", user);
        model.addAttribute("allBooks", bookService.allBooks());
        return "book/all.jsp";
    }

    @GetMapping("/search")
    public String searchBooks(
        @ModelAttribute("book") Book book, 
        @RequestParam("search") String search,   
        Model model,
        @ModelAttribute("error") String error,
        HttpSession session) {
        
        if(bookService.searchBook(search).isEmpty() || search == null) {
            model.addAttribute("error", search +" not found");
            model.addAttribute("allBooks", bookService.allBooks());
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            model.addAttribute("user", user);
            return "book/all.jsp";
        } else {
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            model.addAttribute("user", user);
            model.addAttribute("allBooks", bookService.searchBook(search));
            return "book/all.jsp";
        }
    }

    @GetMapping("/new")
    public String newBook(
        @ModelAttribute("book") Book book,    
        Model model, HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = userService.getUser(user_id);
        model.addAttribute("user", user);
        return "book/add.jsp";
    }

    @PostMapping("/new")
    public String addBook(
        @Valid @ModelAttribute("book") Book book,    
        BindingResult result,
        Model model, 
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        if(result.hasErrors()) {
            Long user_id = (Long) session.getAttribute("user_id");
            User user = userService.getUser(user_id);
            model.addAttribute("user", user);
            return "book/add.jsp";
        }
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showBook(
        @PathVariable("id") Long id,
        @ModelAttribute("book") Book book,    
        Model model, 
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = userService.getUser(user_id);
        model.addAttribute("user", user);
        model.addAttribute("book", bookService.findBook(id));

        return "book/info-one.jsp";
    }

    @GetMapping("/edit/{id}")
    public String editBook(
        @PathVariable("id") Long id,
        @ModelAttribute("book") Book book,    
        Model model,
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        Long user_id = (Long) session.getAttribute("user_id");
        User user = userService.getUser(user_id);
        model.addAttribute("user", user);
        model.addAttribute("book", bookService.findBook(id));
        return "book/edit.jsp";
    }

    @PutMapping("/edit/{id}")
    public String updateBook(
        @PathVariable("id") Long id,
        @Valid 
        @ModelAttribute("book") Book book,    
        BindingResult result,
        Model model, 
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        if(result.hasErrors()) {
            return "book/edit.jsp";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(
        @PathVariable("id") Long id,
        Model model, 
        HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}