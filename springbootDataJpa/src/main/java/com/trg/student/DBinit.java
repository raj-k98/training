package com.trg.student;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.StudentRepository;
import com.trg.student.data.Student;

@Component
public class DBinit implements CommandLineRunner {

	@Autowired
	StudentRepository repo;

	Logger logger = LoggerFactory.getLogger(DBinit.class);

	@Override
	public void run(String... args) throws Exception {

		repo.deleteAll();
		logger.info("All eecords deleted from the table");
		
		repo.save(new Student(100, "Suresh", LocalDate.of(1999, 12, 5), 87.7));
		repo.save(new Student(200, "Girish", LocalDate.of(2001, 12, 5), 56.7));
		repo.save(new Student(300, "Satish", LocalDate.of(2002, 1, 25), 46.5));
		repo.save(new Student(400, "Ganesh", LocalDate.of(2002, 10, 15), 91.7));

		logger.info("4 students records added to the table");

	}

}
