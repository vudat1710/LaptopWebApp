package com.group14.project.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.beans.Product;
import com.group14.project.web.dao.ProductDao;

@Service("productService")
public class ProductService {
	private static final int NO_PRODUCT_PER_PAGE = 9;
	private static final int NO_PRODUCT_SEARCH_RESULT_PER_PAGE = 12;

	@Autowired
	private ProductDao productDao;

	public Product getProductByProductId(String productId) {
		return productDao.getProductByProductId(productId);
	}

	public List<Product> getProductListByPage(int page) {
		return productDao.getProductListByOffsetQuantity(page * NO_PRODUCT_PER_PAGE, NO_PRODUCT_PER_PAGE);
	}

	public List<Product> getProductListByOffsetQuantity(int offset, int quantity) {
		return productDao.getProductListByOffsetQuantity(offset, quantity);
	}

	public List<Product> searchProductByProductIdProductNameSupplierId(String productId, String productName,
			String supplierId) {
		return productDao.searchProductByProductIdProductNameSupplierId(productId, productName, supplierId);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public boolean isProductExisted(String productId) {
		return productDao.isProductExisted(productId);
	}

	public List<Product> searchProductListBySearchValuePage(String searchValue, int page) {
		return productDao.searchProductListBySearchValueOffsetQuantity(searchValue,
				NO_PRODUCT_SEARCH_RESULT_PER_PAGE * page, NO_PRODUCT_SEARCH_RESULT_PER_PAGE);
	}

	public int countNoPageSearchResult(String searchValue) {
		int noProduct = productDao.countNoProductBySearchValue(searchValue);
		return noProduct / NO_PRODUCT_SEARCH_RESULT_PER_PAGE
				+ (noProduct % NO_PRODUCT_SEARCH_RESULT_PER_PAGE == 0 ? 0 : 1);
	}

	public List<Product> getProductListBySupplierIdPage(int supplierId, int page) {
		return productDao.getProductListBySupplierIdOffsetQuantity(supplierId, NO_PRODUCT_SEARCH_RESULT_PER_PAGE * page,
				NO_PRODUCT_SEARCH_RESULT_PER_PAGE);
	}

	public List<Product> getProductListByCategoryIdPage(int supplierID, int page){
		return productDao.getProductListByCategoryIdOffsetQuantity(supplierID, page * NO_PRODUCT_PER_PAGE, NO_PRODUCT_PER_PAGE);
	}

	public int countNoPageBySupplierId(int supplierId) {
		int noProduct = productDao.countNoProductBySupplierId(supplierId);
		return noProduct / NO_PRODUCT_SEARCH_RESULT_PER_PAGE
				+ (noProduct % NO_PRODUCT_SEARCH_RESULT_PER_PAGE == 0 ? 0 : 1);
	}
	
}
