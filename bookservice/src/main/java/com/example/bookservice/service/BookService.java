package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    public Book addBook(Book book) {
        //check if the book title is empty
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        //check if the book author is empty
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be blank");
        }
        return bookRepository.save(book);
    }
}
