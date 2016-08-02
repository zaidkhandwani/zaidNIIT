package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController1 {
	String message = "Welcome to Spring MVC!";

	@RequestMapping("/")
	public String show1() {
		return "home";
	}

	@RequestMapping("/comp")
	public String show2() {
	System.out.println("in controller");
		return "comp";
	}

	@RequestMapping("/tv")
	public String show3() {
		return "tv";
	}
	
	@RequestMapping("/mobile")
	public String show4() {
		return "mobile";
	}
	
	@RequestMapping("/ha")
	public String show5() {
		return "ha";
	}
	
	@RequestMapping("/watch")
	public String show6() {
		return "watch";
	}
	
	@RequestMapping("/home")
	public String show7() {
		return "home";
	}

	@RequestMapping("/login")
	public String show8() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String show9() {
		return "register";
	}
	
	@RequestMapping("/contact")
	public String show10() {
		return "contact";
	}
	@RequestMapping("/validate")
	public ModelAndView method1(@RequestParam("userid") String id, @RequestParam("password") String pass) {
		if (id.equals("admin") && pass.equals("admin")) {
			ModelAndView model = new ModelAndView("admin");
			return model;
		}
		String message = "Invalid Username or Password" + id;
		return new ModelAndView("login", "message", message);

	}
}