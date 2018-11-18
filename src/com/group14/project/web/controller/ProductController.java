package com.group14.project.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	@Autowired
	private ServletContext context;

	@RequestMapping("/viewProductDetail")
	public String viewProductDetail(HttpServletRequest request, Model model) {
		String productId = request.getParameter("productId");
		Product product = productService.getProductByProductId(productId);

		List<Supplier> supplierList = supplierService.getAllSuppliers();

		model.addAttribute("product", product);
		model.addAttribute("supplierList", supplierList);
		return "viewProductDetail";
	}

	@RequestMapping(value = "/addNewProduct", method = RequestMethod.GET)
	public @ResponseBody String addNewProduct(HttpServletRequest request) {
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

		try {
			if (!productService.isProductExisted(productId)) {
				Product product = new Product(productId, productName, productDescription, supplierId, price, cpu, vga,
						ram, hardDisk);

				productService.addProduct(product);

				ajaxResponse = mapper.writeValueAsString(Boolean.TRUE);

			} else {
				ajaxResponse = mapper.writeValueAsString(Boolean.FALSE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ajaxResponse;
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public @ResponseBody String uploadImage(@RequestParam("productImage") MultipartFile productImage,
			@RequestParam("productId") String productId) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();
		String productImageName = productId + ".jpg";

		BufferedOutputStream outputStream;
		try {
			outputStream = new BufferedOutputStream(
					new FileOutputStream(new File(context.getRealPath("/resources/images/product"), productImageName)));
			outputStream.write(productImage.getBytes());
			outputStream.flush();
			outputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ajaxResponse = mapper.writeValueAsString(Boolean.TRUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ajaxResponse;

	}

	@RequestMapping("/viewSearchResult")
	public String viewSearchResult(HttpServletRequest request, Model model) {
		String searchValue = request.getParameter("searchValue");
		int page = Integer.parseInt(request.getParameter("page"));
		int noPage;
		if (request.getParameter("noPage") == null) {
			noPage = productService.countNoPageSearchResult(searchValue);
		} else {
			noPage = Integer.parseInt(request.getParameter("noPage"));
		}

		List<Product> productList = productService.searchProductListBySearchValuePage(searchValue, page);

		model.addAttribute("productList", productList);
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("page", page);
		model.addAttribute("noPage", noPage);

		return "viewSearchResult";
	}

	@RequestMapping("/viewProductBySupplier")
	public String viewProductBySupplier(HttpServletRequest request, Model model) {
		int supplierId = Integer.parseInt(request.getParameter("supplierId"));
		int page = Integer.parseInt(request.getParameter("page"));
		int noPage;
		if (request.getParameter("noPage") != null) {
			noPage = Integer.parseInt(request.getParameter("noPage"));
		} else {
			noPage = productService.countNoPageBySupplierId(supplierId);
		}

		List<Product> productList = productService.getProductListBySupplierIdPage(supplierId, page);
		Supplier supplier = supplierService.getSupplierBySupplierId(supplierId);

		model.addAttribute("supplier", supplier);
		model.addAttribute("page", page);
		model.addAttribute("noPage", noPage);
		model.addAttribute("productList", productList);

		return "viewProductBySupplier";
	}
}
