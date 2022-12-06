package com.assignments.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignments.books.models.Book;
import com.assignments.books.services.BookService;

@RestController
@RequestMapping("/api")
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }

    //create a book
    @PostMapping("/books")
    public Book createBook(
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("language") String language,
        @RequestParam("numberOfPages") Integer numberOfPages
    ) {
        Book book = new Book(title, description, language, numberOfPages);
        return bookService.create(book);
    }

    //find all books
    @GetMapping("/books")
    public List<Book> allBooks() {
        return bookService.allBooks();
    }

    //find one book by id
    @GetMapping("/books/{id}")
    public Book findBook(@RequestParam("id") Long id) {
        return bookService.findBook(id);
    }

    //update a book
    @PutMapping("/books/{id}")
    public Book updateBook(
        @RequestParam("id") Long id,
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("language") String language,
        @RequestParam("numberOfPages") Integer numberOfPages
    ) {
        return bookService.updateBook(id, title, description, language, numberOfPages);
    }

    //delete a book
    @DeleteMapping("/books/{id}")
    public void deleteBook(@RequestParam("id") Long id) {
        bookService.deleteBook(id);
    }
    
    
}
