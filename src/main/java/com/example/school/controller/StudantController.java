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
import com.example.school.model.Studant;
import com.example.school.repository.StudantRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/estudante")
@Slf4j
public class StudantController {
	
	@Autowired
	private StudantRepository studantRepository;
	
	@GetMapping("/estudante")
	public List<Studant> getStudants() {
		return studantRepository.findAll();
	}
	
	@GetMapping("/estudante/{id}")
	public Studant getStudant(@PathVariable("id") Long id) {
		return studantRepository.findById(id).get();
	}
	
	@PostMapping("/estudante")
	public Studant saveStudant(Studant studant) throws BadRequestException {
		if (!Objects.isNull(studant.getId()) ) {
			throw new BadRequestException();
		}
		return studantRepository.save(studant);
	}
	
	@PatchMapping("/estudante")
	public Studant updateStudant(Studant studant) throws BadRequestException {
		if (Objects.isNull(studant.getId()) ) {
			throw new BadRequestException();
		}
		return studantRepository.save(studant);
	}
	
	@DeleteMapping("/estudante/{id}")
	public void deleteStudant(Long id) {
		studantRepository.deleteById(id);
	}
}
