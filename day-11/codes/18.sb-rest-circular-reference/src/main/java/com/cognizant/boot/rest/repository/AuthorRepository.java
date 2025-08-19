package com.cognizant.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.boot.rest.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
