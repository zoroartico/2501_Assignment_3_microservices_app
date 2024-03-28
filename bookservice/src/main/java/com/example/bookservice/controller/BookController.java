package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{title}")
    @Operation(summary = "Get book by title")
    public ResponseEntity<?> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }
    @PostMapping("/add-book")
    @Operation(summary = "Add a new book")
    public Book addBook(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Book details", required = true) @RequestBody Book book) {
        return bookService.addBook(book);
    }
}
