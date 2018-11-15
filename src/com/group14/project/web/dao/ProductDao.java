package com.group14.project.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
