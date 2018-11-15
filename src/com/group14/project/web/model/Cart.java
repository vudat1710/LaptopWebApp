package com.group14.project.web.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> cartItemList;
	private int totalQuantity;
	private int totalPrice;

	public Cart() {
		this.cartItemList = new ArrayList<>();
		this.totalQuantity = 0;
		this.totalPrice = 0;
	}

	public int isCartItemExisted(String productId) {
		for (CartItem cartItem : cartItemList) {
			if (cartItem.getProduct().getProductId().equals(productId)) {
				return cartItemList.indexOf(cartItem);
			}
		}
		return -1;
	}

	public void addCartItem(CartItem cartItem) {
		this.cartItemList.add(cartItem);
		this.totalQuantity += cartItem.getQuantity();
		this.totalPrice += cartItem.getQuantity() * cartItem.getProduct().getPrice();
	}

	public void increaseQuantityByProductId(int index, String productId, int addedQuantity) {
		this.cartItemList.get(index).increaseQuantity(addedQuantity);
		this.totalQuantity += addedQuantity;
		this.totalPrice += addedQuantity * this.cartItemList.get(index).getProduct().getPrice();
	}

	public void removeCartItemByProductId(String productId) {
		int index = isCartItemExisted(productId);
		if (index != -1) {
			this.totalQuantity -= this.cartItemList.get(index).getQuantity();
			this.totalPrice -= this.cartItemList.get(index).getProduct().getPrice()
					* this.cartItemList.get(index).getQuantity();
			this.cartItemList.remove(index);
		}
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
}
