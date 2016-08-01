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

	@RequestMapping("/co")
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
}