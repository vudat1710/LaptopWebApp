package com.group14.project.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group14.project.web.beans.Product;
import com.group14.project.web.model.Cart;
import com.group14.project.web.model.CartItem;
import com.group14.project.web.service.ProductService;
import com.group14.project.web.service.StorageService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private StorageService storageService;

	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public @ResponseBody String addCart(HttpServletRequest request, HttpSession session) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();

		Cart cart = (Cart) session.getAttribute("cart");
		String productId = request.getParameter("productId");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Product product = productService.getProductByProductId(productId);
		int noProductCanAdd = storageService.countNoBookCanAddByProductId(productId);

		int isExisted = cart.isCartItemExisted(productId);
		try {
			if (isExisted != -1) {
				if (noProductCanAdd - cart.getCartItemList().get(isExisted).getQuantity() >= quantity) {
					cart.increaseQuantityByProductId(isExisted, productId, quantity);

					ajaxResponse = mapper.writeValueAsString(cart);

				} else {
					ajaxResponse = mapper.writeValueAsString(Boolean.FALSE);
				}
			}
			else {
				if(noProductCanAdd >= quantity) {
					CartItem cartItem = new CartItem(product, quantity);
					cart.addCartItem(cartItem);
					ajaxResponse = mapper.writeValueAsString(cart);
				}
				else {
					ajaxResponse = mapper.writeValueAsString(Boolean.FALSE);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ajaxResponse;
	}
	
	@RequestMapping("/viewCart")
	public String viewCart(Model model) {
		List<Product> offerProductList = productService.getProductListByOffsetQuantity(0, 4);
		model.addAttribute("offerProductList", offerProductList);
		return "viewCart";
	}
	
	@RequestMapping(value="/removeCartItem", method=RequestMethod.GET)
	public @ResponseBody String removeCartItem(HttpServletRequest request, HttpSession session) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();
		
		String productId = request.getParameter("productId");
		Cart cart = (Cart) session.getAttribute("cart");
		
		cart.removeCartItemByProductId(productId);
		
		try {
			ajaxResponse = mapper.writeValueAsString(cart);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ajaxResponse;
	}
}
