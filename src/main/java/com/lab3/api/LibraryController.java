package com.lab3.api;

import com.lab3.domain.Library;
import com.lab3.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    private final LibraryService libraryService;
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id);
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);
    }

    @DeleteMapping("/{id}")
    public String deleteLibrary(@PathVariable Long id) {
        return libraryService.deleteLibraryIfEmpty(id);
    }
}
