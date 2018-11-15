package com.group14.project.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ordersDetail")
@IdClass(value = OrdersDetailPK.class)
public class OrdersDetail {
	@Id
	private int orderId;
	@Id
	private String productId;
	private int pricePerUnit;
	private int quantity;

	public OrdersDetail() {

	}

	public OrdersDetail(int orderId, String productId, int pricePerUnit, int quantity) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
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

	public int getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(int pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		result = prime * result + pricePerUnit;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersDetail other = (OrdersDetail) obj;
		if (orderId != other.orderId)
			return false;
		if (pricePerUnit != other.pricePerUnit)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
