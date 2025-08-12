package com.cognizant.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
*/
@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Book {
	private Integer bookId;
	private String bookTitle;
	private String bookAuthor;
	private Float bookPrice;	
}