package com.cognizant.boot.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
//@ToString(exclude = "author")
//@EqualsAndHashCode(exclude = "author")
public class Post {
	@Id		
    private Long id;
    private String title;
    private String content;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;
}
