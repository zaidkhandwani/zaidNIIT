package com;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	ServletContext req;
	

	@RequestMapping("/")
	public ModelAndView getAllproduc1t(){
		 System.out.println("getAllproduct");
		 List<Product> productlist = productDAO.list();
		 
		 ModelAndView mv2 = new ModelAndView ("/home");
		 mv2.addObject("productList", productlist);
		
		return mv2;
	}
   
	@RequestMapping("/1")
	public ModelAndView getAllproduct(){
		 System.out.println("getAllproduct");
		 List<Product> productlist = productDAO.list();
		 
		 ModelAndView mv = new ModelAndView ("/home");
		 mv.addObject("productList", productlist);
		
		return mv;
	}
	
	
	@RequestMapping("/add")
	
	public String show()
	{	
		return "addProduct";
		
	}
	

	
	@RequestMapping("/addProduct")
	public ModelAndView product (@ModelAttribute Product product) {
		
		productDAO.save(product);
		
		
	  return new ModelAndView("/success");
	 }
	
	
	@RequestMapping("/delete/{id}")
    public String removeProduct(@PathVariable("id") String id){
		
		
		
        this.productDAO.delete(id);
        return "redirect:/";
    }
 


}
