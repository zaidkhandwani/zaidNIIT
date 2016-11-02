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

import com.dao.UserDetailsDAO;
import com.model.UserDetails;

@RestController
public class UserDetailsController {
	
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Autowired
	private UserDetails userDetails;

	@Autowired
	ServletContext req;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/UserDetails/")
	public ResponseEntity<List<UserDetails>> listAllUserDetails() {
		List<UserDetails> userDetails = userDetailsDAO.listApproved();
		if (userDetails.isEmpty()) {

			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);

	}
	@GetMapping("/UserDetailsPending/")
	public ResponseEntity<List<UserDetails>> listAllPendingUserDetails() {
		List<UserDetails> userDetails = userDetailsDAO.listPending();
		if (userDetails.isEmpty()) {

			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);

	}

	@GetMapping("/UserDetails/{username}")
	public ResponseEntity<UserDetails> getUserDetails(@ModelAttribute("username") String id) {

		UserDetails UserDetails = userDetailsDAO.get(id);
		if (UserDetails == null) {
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<UserDetails>(UserDetails, HttpStatus.OK);
	}

	@PostMapping("/UserSave/")
	public ResponseEntity<Void> createUserDetails(@RequestBody UserDetails userDetails, UriComponentsBuilder ucBuilder) {
		System.out.println("---------------->>>In Save User Detail");
		

		
		
		if (userDetailsDAO.get(userDetails.getEmail()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		userDetails.setStatus("Pending");
		userDetailsDAO.save(userDetails);

		String subject = "Registration Successfull !";
		String emailText1 = "Dear ";
		String emailText2 = ". We have successfully received your request to be a part of HUB. You have requested to register as ";
		String emailText3 = ". We will shortly notify you about your request approval. Thank You";
		System.out.println("To: " + userDetails.getEmail());
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(userDetails.getEmail());
		email.setSubject(subject);
		email.setText(emailText1 + userDetails.getName() + emailText2 + userDetails.getRole() + emailText3);

		mailSender.send(email);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/UserDetails/{id}").buildAndExpand(userDetails.getName()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

	}

	@PutMapping("/UserDetails/{username}")
	public ResponseEntity<UserDetails> update(@ModelAttribute("username") String id,
			@RequestBody UserDetails userDetails) {

		UserDetails UserDetails = userDetailsDAO.get(id);
		if (UserDetails == null) {
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);

		}
		userDetailsDAO.update(UserDetails);
		return new ResponseEntity<UserDetails>(UserDetails, HttpStatus.OK);
	}

	@DeleteMapping("/UserDetails/{username}")
	public ResponseEntity<UserDetails> deleteUser(@ModelAttribute("username") String id) {

		UserDetails UserDetails = userDetailsDAO.get(id);
		if (UserDetails == null) {
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);

		}
		userDetailsDAO.delete(id);
		return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);

	}

	@PostMapping("/UserValidate/")
	public ResponseEntity<UserDetails> checkUser(@RequestBody UserDetails userDetails, HttpSession session, HttpServletRequest request) {

		userDetails = userDetailsDAO.validate(userDetails.getUserId(), userDetails.getPassword());
		if (userDetails == null) {
			userDetails = new UserDetails();
			userDetails.setErrorMessage("Invalid Credentials!");
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		} else if (userDetails.getStatus().equalsIgnoreCase("Pending")) {
			userDetails = new UserDetails();
			userDetails.setErrorMessage("Your Registration Request is not yet Approved.");
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		} else if (userDetails.getStatus().equalsIgnoreCase("Rejected")) {
			userDetails = new UserDetails();
			userDetails.setErrorMessage("Your Request for Registration has been Rejected!");
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		} else{
			session = request.getSession(true);
			if (session != null)
			session.setAttribute("loggedInUserName", userDetails.getName());
			session.setAttribute("loggedInUserID", userDetails.getUserId());
			session.setAttribute("loggedInUserRole", userDetails.getRole());
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		}
	}
}
