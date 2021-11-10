package com.htamayo.sbcrashcourse.fsteps;

/*
ejemplo de inyeccion de clases: clase 3
 */

import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    public BookRepository() {
        System.out.println("BookService created");
    }
}
