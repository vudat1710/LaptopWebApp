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
import com.group14.project.web.beans.OrdersDetail;

@Repository
@Transactional
@Component("ordersDetailDao")
public class OrdersDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersDetail> getOrderDetailByOrderID(int orderID) {
		Criteria criteria = getSession().createCriteria(OrdersDetail.class);
		criteria.add(Restrictions.eq("orderId", orderID));
		return criteria.list();
	}
}
