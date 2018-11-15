package com.group14.project.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group14.project.web.beans.Supplier;

@Repository
@Transactional
@Component("supplierDao")
public class SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSuppliers(){
		Criteria criteria = getSession().createCriteria(Supplier.class);
		return criteria.list();
	}
}
