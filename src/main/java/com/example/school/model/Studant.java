package com.example.school.model;


import java.util.Date;
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
@Table(name="estudante")
@Data
@AllArgsConstructor
public class Studant {
	
	public Studant() {
		
	}
	
	public Studant(Long id, String name, Date dateEnrolment) {
		this.id = id;
		this.name = name;
		this.dateEnrolment = dateEnrolment;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Date dateEnrolment;
	
	@OneToMany(mappedBy = "studant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Enrolment> enrolments;
}
