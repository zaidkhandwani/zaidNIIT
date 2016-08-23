package com;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Cart cart;

	
	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model, HttpSession session) {
		model.addAttribute("cart", new Cart());
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		model.addAttribute("cartList", cartDAO.list(loggedInUserid));
		//model.addAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUserid));
		//System.out.println(cartDAO.getTotalAmount(loggedInUserid));
		
		return "/cartdisplay";

	}

	/* @RequestMapping(value = "/myCart/add/{id}", method = RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id, HttpSession session, Model model) {
		Product product = productDAO.get(id);
		
	
		cart.setCpprice(product.getPrice());
		cart.setCpname(product.getName());
		cart.setQuantity(1);
		cart.setCpid(product.getPid());
		cart.setCpcategory(product.getCategory());
		cart.setCpimage(product.getImage());
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		cart.setCuserid(loggedInUserid);
		cart.setStatus("N");
		cartDAO.save(cart);
        
		System.out.println("Data Saved in cart");
		ModelAndView mv = new ModelAndView ("Cartdisplay");
		model.addAttribute("cart", new Cart());
		
		model.addAttribute("cartList", cartDAO.list(loggedInUserid)); 
		
        
        return mv;

	} */
	
	@RequestMapping("/myCart/add/{id}")
    public String addToCart1(@PathVariable("id") String id, HttpSession session, Model model){
		Product product = productDAO.get(id);
		
		
		cart.setCpprice(product.getPrice());
		cart.setCpname(product.getName());
		cart.setQuantity(1);
		cart.setCpid(product.getPid());
		cart.setCpcategory(product.getCategory());
		cart.setCpimage(product.getImage());
		String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		cart.setCuserid(loggedInUserid);
		cart.setStatus("N");
		cartDAO.save(cart);
		System.out.println("Data Saved in cart");
        return "redirect:/cartSuccess";
    }
	
	@RequestMapping("/cartSuccess")
	public String show456() {
		return "cartsuccess";
	}
	
	@RequestMapping("/cart/delete/{id}")
    public String removeProduct(@PathVariable("id") String id){
		
		
		
        this.cartDAO.delete(id);
        return "redirect:/cartdisplay";
    }

	@RequestMapping("/cartdisplay")
	public ModelAndView getAllproduc1t(HttpSession session){
		 System.out.println("getAllcart");
		 String loggedInUserid = (String) session.getAttribute("loggedInUserID");
		 List<Cart> cartlist = cartDAO.list(loggedInUserid);
		 
		 ModelAndView mv2 = new ModelAndView ("/cartdisplay");
		 mv2.addObject("cartList", cartlist);
		
		return mv2;
	}
}