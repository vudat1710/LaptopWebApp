package com.group14.project.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group14.project.web.beans.Product;

@Repository
@Transactional
@Component("productDao")
public class ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Product getProductByProductId(String productId) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("productId", productId));
		return (Product) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductListByOffsetQuantity(int offset, int quantity){
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(quantity);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")

	public List<Product> getProductListByCategoryIdOffsetQuantity(int supplierId, int offset, int quantity){
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("supplierId", supplierId));
		criteria.setFirstResult(offset);
		criteria.setMaxResults(quantity);
		return criteria.list();
	}

	public List<Product> searchProductByProductIdProductNameSupplierId(String productId, String productName, String supplierId){
		Criteria criteria = getSession().createCriteria(Product.class);
		if(!productId.equals("")) {
			criteria.add(Restrictions.idEq(productId));
		}
		if(!productName.equals("")) {
			criteria.add(Restrictions.ilike("productName", productName + "%"));
		}
		if(!supplierId.equals("")) {
			criteria.add(Restrictions.eq("supplierId", Integer.parseInt(supplierId)));
		}
		
		return criteria.list();
	}
	
	public void updateProduct(Product product) {
		getSession().update(product);
	}
	
	public void addProduct(Product product) {
		getSession().save(product);
	}
	
	public boolean isProductExisted(String productId) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.idEq(productId));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString()) == 1;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> searchProductListBySearchValueOffsetQuantity(String searchValue, int offset, int quantity){
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.ilike("productName", "%" + searchValue + "%"));
		criteria.setFirstResult(offset);
		criteria.setMaxResults(quantity);
		return criteria.list();
	}
	
	public int countNoProductBySearchValue(String searchValue) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.ilike("productName", "%" + searchValue + "%"));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getProductListBySupplierIdOffsetQuantity(int supplierId, int offset, int quantity){
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("supplierId", supplierId));
		criteria.setFirstResult(offset);
		criteria.setMaxResults(quantity);
		return criteria.list();
	}
	
	public int countNoProductBySupplierId(int supplierId) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("supplierId", supplierId));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
}
