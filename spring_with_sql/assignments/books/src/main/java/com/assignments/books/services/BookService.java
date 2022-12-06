package com.assignments.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assignments.books.models.Book;
import com.assignments.books.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //create a book
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    //retrieve all books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    //get one book
    public Book findBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    //update a book
    public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
        Book book = findBook(id);
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNumberOfPages(numOfPages);
        return bookRepository.save(book);
    }

    //delete a book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
}
