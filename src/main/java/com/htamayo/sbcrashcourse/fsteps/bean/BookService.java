package com.htamayo.sbcrashcourse.fsteps.bean;

public class BookService {

    public String findAuthor(final String bookName){
        if(bookName.equals("The Lords of the Rings")){
            return "J.R. Tolkien";
        }
        if(bookName.equals("Sapiens")){
            return "Harrara";
        }
        return "";
    }
}
