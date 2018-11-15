package com.group14.project.web.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;
	private String supplierBrand;
	private String supplierDescription;
	
	public Supplier() {
		
	}

	public Supplier(int supplierId, String supplierBrand, String supplierDescription) {
		this.supplierId = supplierId;
		this.supplierBrand = supplierBrand;
		this.supplierDescription = supplierDescription;
	}

	public Supplier(String supplierBrand, String supplierDescription) {
		super();
		this.supplierBrand = supplierBrand;
		this.supplierDescription = supplierDescription;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierBrand() {
		return supplierBrand;
	}

	public void setSupplierBrand(String supplierBrand) {
		this.supplierBrand = supplierBrand;
	}

	public String getSupplierDescription() {
		return supplierDescription;
	}

	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplierBrand == null) ? 0 : supplierBrand.hashCode());
		result = prime * result + ((supplierDescription == null) ? 0 : supplierDescription.hashCode());
		result = prime * result + supplierId;
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
		Supplier other = (Supplier) obj;
		if (supplierBrand == null) {
			if (other.supplierBrand != null)
				return false;
		} else if (!supplierBrand.equals(other.supplierBrand))
			return false;
		if (supplierDescription == null) {
			if (other.supplierDescription != null)
				return false;
		} else if (!supplierDescription.equals(other.supplierDescription))
			return false;
		if (supplierId != other.supplierId)
			return false;
		return true;
	}

}
