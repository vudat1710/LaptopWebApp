package com.group14.project.web.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	private String productId;
	private String productName;
	private String productDescription;
	private int supplierId;
	private int price;
	private String cpu;
	private String vga;
	private String ram;
	private String hardDisk;

	public Product() {

	}

	public Product(String productId, String productName, String productDescription, int supplierId, int price,
			String cpu, String vga, String ram, String hardDisk) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.supplierId = supplierId;
		this.price = price;
		this.cpu = cpu;
		this.vga = vga;
		this.ram = ram;
		this.hardDisk = hardDisk;
	}

	public Product(String productName, String productDescription, int supplierId, int price, String cpu, String vga,
			String ram, String hardDisk) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.supplierId = supplierId;
		this.price = price;
		this.cpu = cpu;
		this.vga = vga;
		this.ram = ram;
		this.hardDisk = hardDisk;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getSuppliedId() {
		return supplierId;
	}

	public void setSuppliedId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getVga() {
		return vga;
	}

	public void setVga(String vga) {
		this.vga = vga;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpu == null) ? 0 : cpu.hashCode());
		result = prime * result + ((hardDisk == null) ? 0 : hardDisk.hashCode());
		result = prime * result + price;
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((ram == null) ? 0 : ram.hashCode());
		result = prime * result + supplierId;
		result = prime * result + ((vga == null) ? 0 : vga.hashCode());
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
		Product other = (Product) obj;
		if (cpu == null) {
			if (other.cpu != null)
				return false;
		} else if (!cpu.equals(other.cpu))
			return false;
		if (hardDisk == null) {
			if (other.hardDisk != null)
				return false;
		} else if (!hardDisk.equals(other.hardDisk))
			return false;
		if (price != other.price)
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (ram == null) {
			if (other.ram != null)
				return false;
		} else if (!ram.equals(other.ram))
			return false;
		if (supplierId != other.supplierId)
			return false;
		if (vga == null) {
			if (other.vga != null)
				return false;
		} else if (!vga.equals(other.vga))
			return false;
		return true;
	}

}
