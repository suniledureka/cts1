package com.cognizant.boot.security.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.boot.security.models.Product;
import com.cognizant.boot.security.repository.ProductsRepository;

@RestController
//@CrossOrigin - Allow from all origins
@CrossOrigin(origins = "https://localhost:3000") //- Allow from specific origin
public class ProductsRestController {
	
	private List<Product> productsList = ProductsRepository.getProducts();

	@GetMapping("/products")
	public List<Product> getAllProducts(){  
		return productsList; 
	}
	
	@GetMapping("/products/{pid}")
	public Product getProductByProductId(@PathVariable("pid") Integer pid) {
	   Product product = productsList.stream()
			   						 .filter(prod -> prod.productId().equals(pid))
			   						 .findFirst()
			   						 .orElse(null);
	   return product; 
	}	
	
	@PostMapping("/products/new")
	public void addNewProduct(@RequestBody Product product) {
	   productsList.add(product);	   
	}		
	
}
