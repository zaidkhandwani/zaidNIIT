package com;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MainController {

 
	@RequestMapping("/")
	public String show(){
		return "home";
	}
	
	@RequestMapping("/comp")
	public String show1(){
		return "comp";
	}

	@RequestMapping("/tv")
	public String show2(){
		return "tv";
	}
	
	@RequestMapping("/login")
	public String show3(){
		return "login";
	}
}

