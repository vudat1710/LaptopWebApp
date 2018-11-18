package com.group14.project.web.model;

import com.group14.project.web.beans.OrdersDetail;
import com.group14.project.web.beans.Product;

public class OrderDetailItem {
	private int totalSum;
	private Product product;
	private OrdersDetail ordersDetail;
	
	public OrderDetailItem(OrdersDetail ordersDetail, Product product) {
		totalSum = ordersDetail.getPricePerUnit() * ordersDetail.getQuantity();
		this.ordersDetail = ordersDetail;
		this.product = product;
	}

	public OrdersDetail getOrdersDetail() {
		return ordersDetail;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public Product getProduct() {
		return product;
	}
	
}
