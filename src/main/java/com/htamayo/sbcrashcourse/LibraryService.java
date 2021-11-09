package com.htamayo.sbcrashcourse;
/*
ejemplo de inyeccion de clases: clase 1
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class LibraryService {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    public LibraryService() {
        System.out.println("LibraryService object created");
    }

    public BookService getBookService() {
        return bookService;
    }
}
