package com.lab3.repository;

import com.lab3.domain.Book;
import com.lab3.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLibrary(Library library);
}