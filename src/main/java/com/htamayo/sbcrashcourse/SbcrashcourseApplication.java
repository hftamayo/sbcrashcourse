package com.htamayo.sbcrashcourse;

import com.htamayo.sbcrashcourse.lendingengine.domain.model.Balance;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbcrashcourseApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {SpringApplication.run(SbcrashcourseApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(1, "John", "B", 27, "Software Developer", new Balance()));
		userRepository.save(new User(2, "Peter", "C", 21, "Pilot", new Balance()));
		userRepository.save(new User(3, "Henry", "E", 21, "Unemployed", new Balance()));
	}
}
