package com.group14.project.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.beans.Product;
import com.group14.project.web.dao.ProductDao;

@Service("productService")
public class ProductService {
	private static final int NO_PRODUCT_PER_PAGE = 9;
	
	@Autowired
	private ProductDao productDao;
	
	public Product getProductByProductId(String productId) {
		return productDao.getProductByProductId(productId);
	}
	
	public List<Product> getProductListByPage(int page){
		return productDao.getProductListByOffsetQuantity(page * NO_PRODUCT_PER_PAGE, NO_PRODUCT_PER_PAGE);
	}
	
	public List<Product> getProductListByOffsetQuantity(int offset, int quantity){
		return productDao.getProductListByOffsetQuantity(offset, quantity);
	}
	
	public List<Product> getProductListByCategoryIdPage(int supplierID, int page){
		return productDao.getProductListByCategoryIdOffsetQuantity(supplierID, page * NO_PRODUCT_PER_PAGE, NO_PRODUCT_PER_PAGE);
	}
}
