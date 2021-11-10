package com.htamayo.sbcrashcourse.fsteps.bean;

import java.util.List;

public class BookRepository {
    public List<String> findBookByTitles(){
        return List.of("Sapiens", "Lord of the Rings");
    }
}
