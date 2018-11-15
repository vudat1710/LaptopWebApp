package com.group14.project.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group14.project.web.beans.Storage;

@Repository
@Transactional
@Component("storageDao")
public class StorageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public int countNoProductByProductId(String productId) {
		Criteria criteria = getSession().createCriteria(Storage.class);
		criteria.add(Restrictions.eq("productId", productId));
		criteria.setProjection(Projections.sum("quantity"));
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
}
