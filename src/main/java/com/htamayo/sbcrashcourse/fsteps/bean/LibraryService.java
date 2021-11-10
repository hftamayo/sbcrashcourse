package com.htamayo.sbcrashcourse.fsteps.bean;

import com.htamayo.sbcrashcourse.fsteps.bean.BookRepository;
import com.htamayo.sbcrashcourse.fsteps.bean.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryService {
    private BookRepository bookRepository;
    private BookService bookService;

    @Autowired
    public LibraryService(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }
}
