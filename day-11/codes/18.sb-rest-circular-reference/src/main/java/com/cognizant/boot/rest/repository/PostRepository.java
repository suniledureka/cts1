package com.cognizant.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.boot.rest.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
