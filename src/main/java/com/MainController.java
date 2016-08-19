package com;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/")
	public ModelAndView isValidUser(HttpSession session, HttpServletRequest request) {
		
		ModelAndView mv;
		mv = new ModelAndView("home");
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		List<Cart> cartList = cartDAO.list(loggedInUserid);
		mv.addObject("cartSize", cartList.size());
		mv.addObject("isLogin", "true" );
		mv.addObject("isRegister", "true" );
		mv.addObject("isLogout", "false" );
		
		
		return mv;
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
	public ModelAndView home(HttpSession session, HttpServletRequest request) {
		String message;
		ModelAndView mv;
		mv = new ModelAndView("home");
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		List<Cart> cartList = cartDAO.list(loggedInUserid);
		mv.addObject("cartSize", cartList.size());
		message = "Welcome " +loggedInUser;
		mv.addObject("message", message);
		mv.addObject("isLogout", "true" );
	

		return mv;
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpSession session) {
		if (!session.isNew()) {
			session.invalidate();
		}
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

	@RequestMapping("/cart")
	public String show11() {
		return "cartpage";
	}

	@RequestMapping("/search")
	public ModelAndView searchlist(@RequestParam(value = "search") String search) {
		System.out.println("in search handler");
		List<Product> productlist = productDAO.searchlist(search);

		ModelAndView mv2 = new ModelAndView("/product");
		mv2.addObject("productList", productlist);

		return mv2;
	}
			
}
