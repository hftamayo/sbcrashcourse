package com.htamayo.sbcrashcourse;

//import com.htamayo.sbcrashcourse.fsteps.bean.BookRepository;
//import com.htamayo.sbcrashcourse.fsteps.bean.BookService;
import com.htamayo.sbcrashcourse.lendingengine.domain.model.User;
import com.htamayo.sbcrashcourse.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.htamayo.sbcrashcourse.lendingengine"})
//@EntityScan("es.unileon.inso2.model")
@EnableJpaRepositories("com.htamayo.sbcrashcourse.lendingengine.domain.repository")
public class SbcrashcourseApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {SpringApplication.run(SbcrashcourseApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User(1, "John", "B", 27, "Software Developer"));
		userRepository.save(new User(2, "Peter", "C", 21, "Pilot"));
		userRepository.save(new User(3, "Henry", "E", 21, "Unemployed"));
	}
}
