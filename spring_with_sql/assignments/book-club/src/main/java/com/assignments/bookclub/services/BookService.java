package com.assignments.bookclub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.bookclub.models.Book;
import com.assignments.bookclub.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // create a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieve all books
    public Iterable<Book> allBooks() {
        return bookRepository.findAll();
    }

    // retrieve a book
    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    //search for a book
    public List<Book> searchBook(String search) {
        return bookRepository.findByTitleContaining(search);
    }

    //update a book
    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }

    // delete a book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}