package com.prodapt.learningspring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.learningspring.controller.exception.ResourceNotFoundException;
import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.repository.LikeCRUDRepository;
import com.prodapt.learningspring.repository.PostRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ForumRestController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LikeCRUDRepository likeCRUDRepository;
	
	 @GetMapping("/post/{id}")
	  public Post postDetail(@PathVariable int id) throws ResourceNotFoundException {
	    Optional<Post> post = postRepository.findById(id);
	    System.out.println("Hello");
	    System.out.println(post);
	    if (post.isEmpty()) {
	      throw new ResourceNotFoundException("No post with the requested ID");
	    }
	    return post.get();
	   
	  }
}
