package com.group14.project.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group14.project.web.beans.Authority;
import com.group14.project.web.beans.Product;
import com.group14.project.web.beans.Supplier;
import com.group14.project.web.beans.User;
import com.group14.project.web.service.ProductService;
import com.group14.project.web.service.SupplierService;
import com.group14.project.web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private SupplierService supplierService;

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String viewAdminIndex() {
		return "adminIndex";
	}

	@RequestMapping("/viewUsers")
	public String viewUsers() {
		return "viewUsers";
	}

	@RequestMapping(value = "/searchUser", method = RequestMethod.GET)
	public @ResponseBody String searchUsers(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();

		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String name = request.getParameter("name");

		List<User> userList = userService.searchUsersByUserIdUsernameName(userId, username, name);

		try {
			ajaxResponse = mapper.writeValueAsString(userList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ajaxResponse;
	}

	@RequestMapping(value = "/updateRole", method = RequestMethod.GET)
	public @ResponseBody String updateUserRole(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();

		int userId = Integer.parseInt(request.getParameter("userId"));
		Authority authority = Authority.valueOf(request.getParameter("authority"));

		User user = userService.getUserByUserId(userId);

		user.setAuthority(authority);

		userService.updateUser(user);

		try {
			ajaxResponse = mapper.writeValueAsString(Boolean.TRUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ajaxResponse;
	}

	@RequestMapping(value = "/viewProducts")
	public String viewProducts(Model model) {
		List<Supplier> supplierList = supplierService.getAllSuppliers();
		model.addAttribute("supplierList", supplierList);
		return "viewProducts";
	}

	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
	public @ResponseBody String searchProduct(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();

		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String supplierId = request.getParameter("supplierId");

		List<Product> productList = productService.searchProductByProductIdProductNameSupplierId(productId, productName,
				supplierId);

		try {
			ajaxResponse = mapper.writeValueAsString(productList);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ajaxResponse;
	}

	@RequestMapping("/updateProductDetailForm")
	public String viewUpdateProductDetailForm(HttpServletRequest request, Model model) {
		String productId = request.getParameter("productId");

		Product product = productService.getProductByProductId(productId);
		List<Supplier> supplierList = supplierService.getAllSuppliers();

		model.addAttribute("product", product);
		model.addAttribute("supplierList", supplierList);

		return "updateProductDetailForm";
	}

	@RequestMapping(value = "/updateProductDetail", method = RequestMethod.GET)
	public @ResponseBody String updateProductDetail(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();

		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		int supplierId = Integer.parseInt(request.getParameter("supplierId"));
		String cpu = request.getParameter("cpu");
		String vga = request.getParameter("vga");
		String ram = request.getParameter("ram");
		String hardDisk = request.getParameter("hardDisk");
		int price = Integer.parseInt(request.getParameter("price"));
		String productDescription = request.getParameter("productDescription");

		Product product = new Product(productId, productName, productDescription, supplierId, price, cpu, vga, ram,
				hardDisk);

		productService.updateProduct(product);

		try {
			ajaxResponse = mapper.writeValueAsString(Boolean.TRUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ajaxResponse;
	}

	@RequestMapping("/addNewProductForm")
	public String addNewProductForm(Model model) {
		List<Supplier> supplierList = supplierService.getAllSuppliers();
		model.addAttribute("supplierList", supplierList);

		return "addNewProductForm";
	}

	
	
	@RequestMapping("/addNewSupplierForm")
	public String addNewSupplierForm() {
		return "addNewSupplierForm";
	}
}
