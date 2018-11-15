package com.group14.project.web.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private int userId;
	private String shipAddress;
	private int totalPrice;
	private Date orderDate;
	private Date shipDate;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	public Order() {
		
	}

	public Order(int orderId, int userId, String shipAddress, int totalPrice, Date orderDate, Date shipDate,
			OrderStatus status) {
		this.orderId = orderId;
		this.userId = userId;
		this.shipAddress = shipAddress;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.status = status;
	}

	public Order(int userId, String shipAddress, int totalPrice, Date orderDate, Date shipDate, OrderStatus status) {
		this.userId = userId;
		this.shipAddress = shipAddress;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.shipDate = shipDate;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((shipAddress == null) ? 0 : shipAddress.hashCode());
		result = prime * result + ((shipDate == null) ? 0 : shipDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + totalPrice;
		result = prime * result + userId;
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
		Order other = (Order) obj;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (shipAddress == null) {
			if (other.shipAddress != null)
				return false;
		} else if (!shipAddress.equals(other.shipAddress))
			return false;
		if (shipDate == null) {
			if (other.shipDate != null)
				return false;
		} else if (!shipDate.equals(other.shipDate))
			return false;
		if (status != other.status)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
}
