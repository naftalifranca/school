package com.example.school;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.school.model.Course;
import com.example.school.model.Enrolment;
import com.example.school.model.Studant;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.EnrolmentRepository;
import com.example.school.repository.StudantRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadDatabase(CourseRepository courseRepository, EnrolmentRepository enrolmentRepository,
			StudantRepository studantRepository) {
		log.info("Loading data...");
		
		if (courseRepository.count() > 0 || enrolmentRepository.count() > 0 || studantRepository.count() > 0) {
			return (args) -> {
				log.info("Database is not empty");
			};
		}

		return (args) -> {
			
			courseRepository.save(new Course(1L, "Course 1", 6));
			courseRepository.save(new Course(2L, "Course 2", 4));
			courseRepository.save(new Course(3L, "Course 3", 20));
			
			studantRepository.save(new Studant(1L, "Jhon", new Date()));
			studantRepository.save(new Studant(2L, "David", new Date()));
			studantRepository.save(new Studant(3L, "Mike", new Date()));
			studantRepository.save(new Studant(4L, "Bob", new Date()));
			studantRepository.save(new Studant(5L, "Peter", new Date()));
			
			enrolmentRepository.save(new Enrolment(1L, courseRepository.findById(1L).get(), studantRepository.findById(1L).get()));
			enrolmentRepository.save(new Enrolment(2L, courseRepository.findById(2L).get(), studantRepository.findById(2L).get()));
			enrolmentRepository.save(new Enrolment(3L, courseRepository.findById(3L).get(), studantRepository.findById(3L).get()));
			enrolmentRepository.save(new Enrolment(4L, courseRepository.findById(1L).get(), studantRepository.findById(4L).get()));
			enrolmentRepository.save(new Enrolment(5L, courseRepository.findById(2L).get(), studantRepository.findById(5L).get()));
			
			List<Enrolment> listEnrolment1 = new ArrayList<Enrolment>();
			listEnrolment1.add(enrolmentRepository.findById(1L).get());
			listEnrolment1.add(enrolmentRepository.findById(4L).get());
			
			List<Enrolment> listEnrolment2 = new ArrayList<Enrolment>();
			listEnrolment2.add(enrolmentRepository.findById(2L).get());
			listEnrolment2.add(enrolmentRepository.findById(5L).get());
			
			List<Enrolment> listEnrolment3 = new ArrayList<Enrolment>();
			listEnrolment3.add(enrolmentRepository.findById(3L).get());
			
			courseRepository.save(new Course(1L, "Course 1", 6, listEnrolment1));
			courseRepository.save(new Course(2L, "Course 2", 4, listEnrolment2));
			courseRepository.save(new Course(3L, "Course 3", 20, listEnrolment3));
			
			List<Enrolment> listEnrolment4 = new ArrayList<Enrolment>();
			listEnrolment4.add(enrolmentRepository.findById(1L).get());
			
			List<Enrolment> listEnrolment5 = new ArrayList<Enrolment>();
			listEnrolment5.add(enrolmentRepository.findById(2L).get());
			
			List<Enrolment> listEnrolment6 = new ArrayList<Enrolment>();
			listEnrolment6.add(enrolmentRepository.findById(3L).get());
			
			List<Enrolment> listEnrolment7 = new ArrayList<Enrolment>();
			listEnrolment7.add(enrolmentRepository.findById(4L).get());
			
			List<Enrolment> listEnrolment8 = new ArrayList<Enrolment>();
			listEnrolment8.add(enrolmentRepository.findById(5L).get());
			
			studantRepository.save(new Studant(1L, "Jhon", new Date(), listEnrolment4));
			studantRepository.save(new Studant(2L, "David", new Date(), listEnrolment5));
			studantRepository.save(new Studant(3L, "Mike", new Date(), listEnrolment6));
			studantRepository.save(new Studant(4L, "Bob", new Date(), listEnrolment7));
			studantRepository.save(new Studant(5L, "Peter", new Date(), listEnrolment8));
		};
	}

}
