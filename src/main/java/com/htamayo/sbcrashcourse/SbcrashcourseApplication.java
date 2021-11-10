package com.htamayo.sbcrashcourse;

import com.htamayo.sbcrashcourse.fsteps.bean.BookRepository;
import com.htamayo.sbcrashcourse.fsteps.bean.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbcrashcourseApplication {

	public static void main(String[] args) {SpringApplication.run(SbcrashcourseApplication.class, args);}
	@Bean
	public BookRepository bookRepository(){
		return new BookRepository();
	}

	@Bean
	public BookService bookService(){
		return new BookService();
	}
}
