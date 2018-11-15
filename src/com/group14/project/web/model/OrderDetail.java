package com.group14.project.web.model;

import java.util.List;

import com.group14.project.web.beans.Order;
import com.group14.project.web.beans.User;

public class OrderDetail {
	private User user;
	private Order order;
	private List<OrderDetailItem> orderDetailItems;
	
	public OrderDetail() {
		
	}

	public OrderDetail(User user, Order order, List<OrderDetailItem> orderDetailItems) {
		this.user = user;
		this.order = order;
		this.orderDetailItems = orderDetailItems;
	}

	public User getUser() {
		return user;
	}

	public Order getOrder() {
		return order;
	}

	public List<OrderDetailItem> getOrderDetailItems() {
		return orderDetailItems;
	}

}
