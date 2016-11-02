package com.controller;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dao.BlogDAO;
import com.dao.UserDetailsDAO;
import com.model.Blog;


@RestController
public class BlogController {
	
	
//	@Autowired
//	SessionFactory sessionFactory;
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private Blog blog;
	
	
	@Autowired
	ServletContext req;

	@GetMapping("/Blogs/")
	public ResponseEntity<List<Blog>> listAllBlog() {
		List<Blog> blog = blogDAO.listApproved();
		if (blog.isEmpty()) {

			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);

	}
	
	@GetMapping("/BlogsPending/")
	public ResponseEntity<List<Blog>> listAllBlog2() {
		List<Blog> blog = blogDAO.listPending();
		if (blog.isEmpty()) {

			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);

	}
	
	@GetMapping("/Blog/{id}")
	public ResponseEntity<Blog> getUserDetails(@ModelAttribute("id") String id) {

		Blog Blog = blogDAO.get(id);
		if (Blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<Blog>(Blog, HttpStatus.OK);
	}

	@PostMapping("/BlogSave/")
	public ResponseEntity<Void> createUserDetails(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
		System.out.println("---------------->>>In Save User Detail");
		
		blog.setStatus("Pending");
		blogDAO.save(blog);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Blog/{id}").buildAndExpand(blog.getTitle()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@PutMapping("/ApproveBlog/{id}")
	public ResponseEntity<Blog> update(@ModelAttribute("id") String id, @RequestBody Blog blog) {

		Blog Blog = blogDAO.get(id);
		if (Blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);

		}
		blog.setStatus("Approved");
		blogDAO.update(Blog);
		return new ResponseEntity<Blog>(Blog, HttpStatus.OK);
	}

	@DeleteMapping("/Blog/{id}")
	public ResponseEntity<Blog> deleteBlog(@ModelAttribute("id") String id) {

		Blog Blog = blogDAO.get(id);
		if (Blog == null) {
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);

		}
		blogDAO.delete(id);
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);

	}

	
}
