package com;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	ServletContext req;

	@RequestMapping("product")
	public ModelAndView getAllproduc1t() {
		System.out.println("getAllproduct");
		List<Product> productlist = productDAO.list();

		ModelAndView mv2 = new ModelAndView("/product");
		mv2.addObject("productList", productlist);

		return mv2;
	}

	@RequestMapping("/1")
	public ModelAndView getAllproduct() {
		System.out.println("getAllproduct");
		List<Product> productlist = productDAO.list();

		ModelAndView mv = new ModelAndView("/product");
		mv.addObject("productList", productlist);

		return mv;
	}

	@RequestMapping("/add")

	public String show() {
		return "addProduct";

	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") String id) {

		ModelAndView mv = new ModelAndView("/editProduct");
		mv.addObject("pid", id);
		System.out.println(id);
		return mv;
	}

	@RequestMapping("/addProduct")
	public ModelAndView product(@ModelAttribute Product product) {

		String z = req.getRealPath("/");
		String path = product.getFilePath(z, req.getContextPath());
		System.out.println(path);

		productDAO.saveOrUpdate(product);

		return new ModelAndView("/success");
	}
	
	@RequestMapping("/editProduct")
	public String updateProduct(@ModelAttribute Product product) {

		String z = req.getRealPath("/");
		String path = product.getFilePath(z, req.getContextPath());
		System.out.println(path);

		productDAO.update(product);

		return "redirect:editsuccess";
	}
	
	@RequestMapping("/editsuccess")

	public String show44() {
		return "editsuccess";

	}
	
	
	@RequestMapping("/delete/{id}")
	public String removeProduct(@PathVariable("id") String id) {

		this.productDAO.delete(id);
		return "redirect:/product";
	}

	@RequestMapping("/pp")
	public ModelAndView getAllproduct2() {
		System.out.println("getAllproduct");
		List<Product> productlist = productDAO.list();

		ModelAndView mv = new ModelAndView("/productpage");
		mv.addObject("productList", productlist);

		return mv;
	}
	
	@RequestMapping("laptoplist")
	public ModelAndView getAllproduct3() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Laptop");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	
	@RequestMapping("ledlist")
	public ModelAndView getAllproduct9() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("LED");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	
	@RequestMapping("android")
	public ModelAndView getAllproduct4() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Android");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	@RequestMapping("apple")
	public ModelAndView getAllproduct41() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Apple");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	
	@RequestMapping("windows")
	public ModelAndView getAllproduct42() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Windows");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	
	@RequestMapping("desktops")
	public ModelAndView getAllproduct43() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Desktop");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	@RequestMapping("printers")
	public ModelAndView getAllproduct44() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Printer");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	@RequestMapping("km")
	public ModelAndView getAllproduct45() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Keyboard");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	@RequestMapping("headphones")
	public ModelAndView getAllproduct46() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Headphone");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}
	
	@RequestMapping("ss")
	public ModelAndView getAllproduct47() {
		System.out.println("getAllproduct");

		List<Product> productlist = productDAO.categorylist("Sound");

		ModelAndView mv2 = new ModelAndView("/productpage");
		mv2.addObject("productList", productlist);

		return mv2;
	}

}
