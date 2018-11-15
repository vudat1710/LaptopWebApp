package com.group14.project.web.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrdersDetailPK implements Serializable {
	private int orderId;
	private int productId;

	public OrdersDetailPK() {

	}

	public OrdersDetailPK(int orderId, int productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
