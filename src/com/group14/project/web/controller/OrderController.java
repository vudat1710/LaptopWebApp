package com.group14.project.web.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/viewOrderDetail")
//	public String viewOrderDetail(HttpServletRequest request, Model model) {
//		String orderID = request.getParameter("orderId");
//		Order order = orderService.getOrderByOrderID(Integer.parseInt(orderID));
//		
//		model.addAttribute("order", order);
//		return "viewOrderDetail";
//	}
	
	@RequestMapping("/viewOrder")
	public String viewOrders(HttpServletRequest request, Model model) throws ParseException {
		if (request.getParameter("orderId") == null && request.getParameter("userId") == null
				&& request.getParameter("orderDate") == null && request.getParameter("shipDate") == null) {
			List<Order> orders = orderService.getOrderListByOffsetQuantity(0, 10);
			model.addAttribute("orders", orders);
		}

		if (request.getParameter("orderId") != null || request.getParameter("userId") != null ||
				request.getParameter("orderDate") != null || request.getParameter("shipDate") != null) {
			List<Order> orders = orderService.getOrderListBySearchElements(request.getParameter("orderId"), request.getParameter("userId"), request.getParameter("orderDate"), request.getParameter("shipDate"));
			model.addAttribute("orders", orders);
		}
		return "viewOrder";
	}
	
}
