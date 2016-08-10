package com;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private User user;
	
	@Autowired
	ServletContext req;

	

	

	

	

	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {

		userDAO.saveOrUpdate(user);
		String message;

		ModelAndView mv;
		
			message = "Registration Successful! Please Login";
			mv = new ModelAndView("login");
		
			
		mv.addObject("message", message);
		
		return mv;
		
	}
	@RequestMapping("/validate")
	public ModelAndView isValidUser(@RequestParam(value = "userid") String username,
			@RequestParam(value = "password") String password) {

		String message;

		ModelAndView mv;
		if (userDAO.validate(username, password)) {
			if (userDAO.validateadmin(username, password)){
			
			mv = new ModelAndView("admin");
			}
			else {
				
				mv = new ModelAndView("home");
				}
			}
			else {
			message = "Invalid Username or Password";
			mv = new ModelAndView("login");
			mv.addObject("message", message);
			}

		
		
		return mv;
	}



















}
	

	


