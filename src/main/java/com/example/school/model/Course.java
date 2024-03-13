package com.example.school.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="curso")
@Data
@AllArgsConstructor
public class Course {
	
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	public Course(Long id, String title, Integer credits) {
		this.id = id;
		this.title = title;
		this.credits = credits;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private Integer credits;
	
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Enrolment> enrolments;
}
