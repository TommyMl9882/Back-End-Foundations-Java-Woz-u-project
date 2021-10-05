package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	PostRepository postRepository;
	@GetMapping()
	public ResponseEntity<List<Post>> getPosts(){
		List<Post> results = postRepository.findAll();
		return ResponseEntity.ok(results);
	}
	@GetMapping("{id}")
	public ResponseEntity<Post> getPost(@RequestParam Long id) {
		Post foundPost = postRepository.findById(id).orElse(null); 
		if(foundPost == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(foundPost);		
	}
	@PostMapping()
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		post.setTimeStamp(LocalDateTime.now(), null);
		Post newPost = postRepository.save(post);
		return ResponseEntity.ok(newPost);
	}

	@PutMapping({"id"})
	public ResponseEntity<Post> updatePost(@RequestParam Long id, @RequestBody Post post){
		Post foundPost = postRepository.findById(id).orElse(null); 
		if(foundPost == null) {
			return ResponseEntity.notFound().build();
		}
	foundPost.setAuthorID(post.getAuthorID());
	foundPost.setMessage(post.getMessage());
	foundPost.setTimestamp(LocalDateTime.now());
	postRepository.save(foundPost);
		return ResponseEntity.ok(foundPost);
	}
	
	
	
}