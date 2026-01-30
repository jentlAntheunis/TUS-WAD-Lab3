package com.lab3.api;

import com.lab3.domain.Book;
import com.lab3.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/libraries/{libraryId}/books")
    public List<Book> getBooksByLibrary(@PathVariable Long libraryId) {
        return bookService.getBooksByLibrary(libraryId);
    }

    @PostMapping("/libraries/{libraryId}/books")
    public Book createBook(@PathVariable Long libraryId, @RequestBody Book book) {
        return bookService.createBook(libraryId, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
