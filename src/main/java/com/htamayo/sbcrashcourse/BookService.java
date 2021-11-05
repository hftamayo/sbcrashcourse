package com.htamayo.sbcrashcourse;

/*
ejemplo de inyeccion de clases: clase 2
 */


import org.springframework.stereotype.Component;

@Component
public class BookService {

    public BookService() {
        System.out.println("BookService created");
    }
}
