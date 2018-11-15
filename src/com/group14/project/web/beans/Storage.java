package com.group14.project.web.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storage")
public class Storage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int packageId;
	private String productId;
	private Date importDate;
	private int quantity;
	private int importPrice;

	public Storage() {

	}

	public Storage(int packageId, String productId, Date importDate, int quantity, int importPrice) {
		this.packageId = packageId;
		this.productId = productId;
		this.importDate = importDate;
		this.quantity = quantity;
		this.importPrice = importPrice;
	}

	public Storage(String productId, Date importDate, int quantity, int importPrice) {
		this.productId = productId;
		this.importDate = importDate;
		this.quantity = quantity;
		this.importPrice = importPrice;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(int importPrice) {
		this.importPrice = importPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((importDate == null) ? 0 : importDate.hashCode());
		result = prime * result + importPrice;
		result = prime * result + packageId;
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
		Storage other = (Storage) obj;
		if (importDate == null) {
			if (other.importDate != null)
				return false;
		} else if (!importDate.equals(other.importDate))
			return false;
		if (importPrice != other.importPrice)
			return false;
		if (packageId != other.packageId)
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
