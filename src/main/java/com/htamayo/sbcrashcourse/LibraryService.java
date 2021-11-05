package com.htamayo.sbcrashcourse;
/*
ejemplo de inyeccion de clases: clase 1
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class LibraryService {
    private BookService bookService;
    private BookRepository bookRepository;

    @Autowired
    public LibraryService(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
        System.out.println("LibraryService object created");
    }
}
