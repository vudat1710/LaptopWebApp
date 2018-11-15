package com.group14.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group14.project.web.beans.Product;
import com.group14.project.web.beans.Supplier;
import com.group14.project.web.model.Cart;
import com.group14.project.web.service.ProductService;
import com.group14.project.web.service.SupplierService;

@Controller
public class HomeController {

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String home(Model model, HttpSession session) {
		List<Product> productList = productService.getProductListByPage(0);
		List<Supplier> supplierList = supplierService.getAllSuppliers();

		model.addAttribute("productList", productList);
		model.addAttribute("supplierList", supplierList);

		if(session.getAttribute("cart") == null) {
			session.setAttribute("cart", new Cart());
		}
		

		return "home";
	}

	@RequestMapping("/registerForm")
	public String registerForm() {
		return "registerForm";
	}
	


}
