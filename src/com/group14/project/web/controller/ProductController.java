package com.group14.project.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group14.project.web.beans.Product;
import com.group14.project.web.beans.Supplier;
import com.group14.project.web.service.ProductService;
import com.group14.project.web.service.SupplierService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/viewProductDetail")
	public String viewProductDetail(HttpServletRequest request, Model model) {
		String productId = request.getParameter("productId");
		Product product = productService.getProductByProductId(productId);
		
		List<Supplier> supplierList = supplierService.getAllSuppliers();
		
		model.addAttribute("product", product);
		model.addAttribute("supplierList", supplierList);
		return "viewProductDetail";
	}
}
