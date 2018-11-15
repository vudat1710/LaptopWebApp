package com.group14.project.web.model;

import com.group14.project.web.beans.OrdersDetail;

public class OrderDetailItem {
	private int totalSum;
	private OrdersDetail ordersDetail;
	
	public OrderDetailItem(OrdersDetail ordersDetail) {
		totalSum = ordersDetail.getPricePerUnit() * ordersDetail.getQuantity();
		this.ordersDetail = ordersDetail;
	}

	public OrdersDetail getOrdersDetail() {
		return ordersDetail;
	}

	public int getTotalSum() {
		return totalSum;
	}
}
