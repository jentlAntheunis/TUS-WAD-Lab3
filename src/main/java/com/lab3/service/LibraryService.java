package com.lab3.service;

import com.lab3.domain.Library;
import com.lab3.repository.BookRepository;
import com.lab3.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    public LibraryService(LibraryRepository libraryRepository,  BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library getLibraryById(Long id) {
        return libraryRepository.getReferenceById(id);
    }

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibrary(Long id) {
        libraryRepository.deleteById(id);
    }

    public String deleteLibraryIfEmpty(Long id) {
        Library library = libraryRepository.getReferenceById(id);
        if (bookRepository.findByLibrary(library).isEmpty()) {
            libraryRepository.deleteById(id);
            return "Library has been deleted";
        }
        return "Library has not been deleted, books inside";
    }
}
