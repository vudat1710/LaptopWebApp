package com.group14.project.web.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group14.project.web.beans.Order;
import com.group14.project.web.beans.User;
import com.group14.project.web.service.OrderService;
import com.group14.project.web.service.UserService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/viewOrderDetail")
	public String viewOrderDetail(HttpServletRequest request, Model model) {
		String orderID = request.getParameter("orderId");
		Order order = orderService.getOrderByOrderID(Integer.parseInt(orderID));
		
		model.addAttribute("order", order);
		return "viewOrderDetail";
	}
}
