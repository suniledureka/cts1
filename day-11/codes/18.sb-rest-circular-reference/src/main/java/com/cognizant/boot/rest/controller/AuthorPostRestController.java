package com.cognizant.boot.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.boot.rest.entity.Author;
import com.cognizant.boot.rest.entity.Post;
import com.cognizant.boot.rest.repository.AuthorRepository;
import com.cognizant.boot.rest.repository.PostRepository;

@RestController
@RequestMapping("/api/v1")
public class AuthorPostRestController {
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private PostRepository postRepo;	
	
	@PostMapping(path = "/create")
	public ResponseEntity<String> saveUserAndPost(@RequestBody Author author){
		Author authorIn = new Author();
		authorIn.setId(author.getId());
		authorIn.setName(author.getName());
		
		List<Post> posts = new ArrayList<Post>();
		for(Post pst : author.getPosts()) {
			Post post = new Post();
			post.setId(pst.getId());
			post.setTitle(pst.getTitle());
			post.setContent(pst.getContent());
			post.setAuthor(authorIn);
			
			posts.add(post);
		}
		
		authorIn.setPosts(posts);
		
		authorRepo.save(authorIn);
		
		return ResponseEntity.status(HttpStatus.OK).body("Author saved with Post");
	}
	
	@PostMapping("/savepost")
	public ResponseEntity<String> savePostForUser(@RequestParam Long id, @RequestBody Post post){
		System.out.println(id);
		Optional<Author> optAuthor = authorRepo.findById(id);
		if(optAuthor.isPresent()) {
			Author author = optAuthor.get();
			post.setAuthor(author);
			List<Post> posts = new ArrayList<Post>();
			posts.add(post);
			author.setPosts(posts);
			authorRepo.save(author);
			return ResponseEntity.status(HttpStatus.CREATED).body("Post added");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Author Not Found");
	}
	
	@GetMapping("/getauthor/{id}")
	public Author getAuthorById(@PathVariable Long id) {
		Optional<Author> optAuthor = authorRepo.findById(id);
		if(optAuthor.isPresent()) {
			Author author = optAuthor.get();
			return author;
		}
		return null;
	}
	
	@GetMapping("/getpost/{id}")
	public Post getPostById(@PathVariable("id") Long id) {
		System.out.println(id);
		Optional<Post> optPost = postRepo.findById(id);
		if(optPost.isPresent()) {
			Post post = optPost.get();
			System.out.println(post.getAuthor().getId());
			return post;
		}
		return null;
	}	
}
