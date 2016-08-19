package com;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	private Product product;

	@Autowired
	private User user;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	ServletContext req;

	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		user.setRole("User");
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
			@RequestParam(value = "password") String password, HttpSession session, HttpServletRequest request) {

		String message;

		ModelAndView mv;
		if (userDAO.validate(username, password)) {
			user = userDAO.get(username);
			session = request.getSession(true);
			if (session != null)
				session.setAttribute("loggedInUser", user.getUname());
			session.setAttribute("loggedInUserID", user.getUid());
			session.setAttribute("product", product);

			if (userDAO.validateadmin(username, password)) {

				mv = new ModelAndView("admin");
				List<Cart> cartList = cartDAO.list(username);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());
				mv.addObject("isLogin", "false");
				mv.addObject("isLogout", "true");
				mv.addObject("isRegister", "false");

				String loggedInUser = (String) session.getAttribute("loggedInUser");
				message = "Welcome " + loggedInUser;
				mv.addObject("message", message);
			} else {

				mv = new ModelAndView("home");
				cart = cartDAO.get(username);
				mv.addObject("cart", cart);
				List<Cart> cartList = cartDAO.list(username);
				mv.addObject("cartList", cartList);
				mv.addObject("cartSize", cartList.size());
				mv.addObject("isLogin", "false");
				mv.addObject("isLogout", "true");
				mv.addObject("isRegister", "false");

				String loggedInUser = (String) session.getAttribute("loggedInUser");
				message = "Welcome " + loggedInUser;
				mv.addObject("message", message);
			}
		} else {
			message = "Invalid Username or Password";
			mv = new ModelAndView("login");
			mv.addObject("message", message);
		}

		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView addUser(HttpSession session, HttpServletRequest request) {
		System.out.println("inside logout controller");

		session = request.getSession(false);
		if (session != null)
			session.invalidate();

		ModelAndView mv;

		mv = new ModelAndView("home");
		
		mv.addObject("isLogin", "true" );
		mv.addObject("isRegister", "true" );
		mv.addObject("isLogout", "false" );
		return mv;

	}

	

}
