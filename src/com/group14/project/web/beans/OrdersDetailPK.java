package com.group14.project.web.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrdersDetailPK implements Serializable {
	private int orderId;
	private String productId;

	public OrdersDetailPK() {

	}

	public OrdersDetailPK(int orderId, String productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
