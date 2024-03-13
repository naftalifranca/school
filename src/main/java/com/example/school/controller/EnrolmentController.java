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

import com.example.school.model.Enrolment;
import com.example.school.repository.EnrolmentRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/matricula")
@Slf4j
public class EnrolmentController {
	
	@Autowired
	private EnrolmentRepository enrolmentRepository;
	
	@GetMapping("/matricula")
	public List<Enrolment> getEnrolments() {
		return enrolmentRepository.findAll();
	}
	
	@GetMapping("/matricula/{id}")
	public Enrolment getEnrolment(@PathVariable("id") Long id) {
		return enrolmentRepository.findById(id).get();
	}
	
	@PostMapping("/matricula")
	public Enrolment saveEnrolment(Enrolment enrolment) throws BadRequestException {
		if (!Objects.isNull(enrolment.getId()) ) {
			throw new BadRequestException();
		}
		return enrolmentRepository.save(enrolment);
	}
	
	@PatchMapping("/matricula")
	public Enrolment updateEnrolment(Enrolment enrolment) throws BadRequestException {
		if (Objects.isNull(enrolment.getId()) ) {
			throw new BadRequestException();
		}
		return enrolmentRepository.save(enrolment);
	}
	
	@DeleteMapping("/matricula/{id}")
	public void deleteEnrolment(Long id) {
		enrolmentRepository.deleteById(id);
	}
}
