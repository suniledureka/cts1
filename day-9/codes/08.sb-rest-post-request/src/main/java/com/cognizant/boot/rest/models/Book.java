package com.cognizant.boot.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@JsonProperty("bid")
	@XmlElement(name = "bid")
	private Integer bookId;
	
	@JsonProperty(value = "title")
	@XmlElement(name = "title")
	private String bookTitle;
	
	@JsonProperty("price")
	@XmlElement(name = "price")
	private Float bookPrice;
}
