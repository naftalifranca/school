package com.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.model.Enrolment;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Long> {

}
