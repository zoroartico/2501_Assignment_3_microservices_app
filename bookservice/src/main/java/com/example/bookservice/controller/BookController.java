package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID")
    public Book getBookById(
            @Parameter(description = "Book ID", required = true) @PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add-book")
    @Operation(summary = "Add a new book")
    public Book addBook(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Book details", required = true) @RequestBody Book book) {
        return bookService.addBook(book);
    }
}
