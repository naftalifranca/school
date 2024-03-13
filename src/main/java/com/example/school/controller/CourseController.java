package com.example.school.controller;

import java.util.List;
import java.util.Objects;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school.model.Course;
import com.example.school.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/curso")
@Slf4j
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/curso")
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}
	
	@GetMapping("/curso/{id}")
	public Course getCourse(@PathVariable("id") Long id) {
		return courseRepository.findById(id).get();
	}
	
	@PostMapping("/curso")
	public Course saveCourse(Course course) throws BadRequestException {
		if (!Objects.isNull(course.getId()) ) {
			throw new BadRequestException();
		}
		return courseRepository.save(course);
	}
	
	@PatchMapping("/curso")
	public Course updateCourse(Course course) throws BadRequestException {
		if (Objects.isNull(course.getId()) ) {
			throw new BadRequestException();
		}
		return courseRepository.save(course);
	}
	
	@DeleteMapping("/curso/{id}")
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}
