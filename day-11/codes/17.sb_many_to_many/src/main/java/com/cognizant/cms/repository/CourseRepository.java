package com.cognizant.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.cms.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
