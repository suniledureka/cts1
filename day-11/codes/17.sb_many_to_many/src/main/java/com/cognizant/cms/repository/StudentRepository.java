package com.cognizant.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.cms.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
