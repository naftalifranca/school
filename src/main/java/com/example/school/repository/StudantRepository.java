package com.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.school.model.Studant;

public interface StudantRepository extends JpaRepository<Studant, Long> {

}
