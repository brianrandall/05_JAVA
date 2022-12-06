package com.assignments.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.books.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
    
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String allBooks(Model model) {
        model.addAttribute("allBooks", bookService.allBooks());
        return "allBooks.jsp";
    }

    @GetMapping("/{id}")
    public String oneBook(Model model, @PathVariable("id") Long id) {
        model.addAttribute("oneBook", bookService.findBook(id));
        return "one-book.jsp";
    }

}
