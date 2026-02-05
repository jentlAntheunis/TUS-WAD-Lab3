package com.lab3.service;

import com.lab3.domain.Book;
import com.lab3.domain.Library;
import com.lab3.repository.BookRepository;
import com.lab3.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    public BookService(BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.getReferenceById(id);
    }

    public List<Book> getBooksByLibrary(Long libraryId) {
        Library library = libraryRepository.getReferenceById(libraryId);
        return bookRepository.findByLibrary(library);
    }

    public Book createBook(Long libraryId, Book book) {
        Library library = libraryRepository.getReferenceById(libraryId);
        book.setLibrary(library);
        if (Objects.equals(book.getTitle(), "") || Objects.equals(book.getTitle(), null)) {return null;}
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
