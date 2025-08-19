package com.cognizant.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.students.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}