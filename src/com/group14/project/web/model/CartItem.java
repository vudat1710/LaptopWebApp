package com.group14.project.web.model;

import com.group14.project.web.beans.Product;

public class CartItem {
	private Product product;
	private int quantity;

	public CartItem() {

	}

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void increaseQuantity(int addedQuantity) {
		this.quantity += addedQuantity;
	}

}
