package com.group14.project.web.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group14.project.web.beans.Order;

@Repository
@Transactional
@Component("orderDao")
public class OrderDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveUser(Order order) {
		getSession().save(order);
	}
	
	public Order getOrderByOrderID(int orderID) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.idEq(orderID));
		return (Order) criteria.uniqueResult();
	}
	
	public int getUserIdByOrderId(int orderID) {
		Criteria criteria = getSession().createCriteria(Order.class)
				.setProjection(Projections.projectionList())
				.add((Criterion) Projections.property("userId"))
				.setResultTransformer(Transformers.aliasToBean(Order.class));
		return (int) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrderListBySearchElements(String orderID, String userID, Date orderDate, Date shipDate) {
		Criteria criteria = getSession().createCriteria(Order.class);
		if (!orderID.isEmpty()) {
			criteria.add(Restrictions.idEq(Integer.parseInt(orderID)));
		}
		if (!userID.isEmpty()) {
			criteria.add(Restrictions.eq("userId",Integer.parseInt(userID)));
		}
		if (orderDate != null) {
			criteria.add(Restrictions.eq("orderDate", orderDate));
		}
		if (shipDate != null) {
			criteria.add(Restrictions.eq("shipDate", shipDate));
		}
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrderListByOffsetQuantity(int offset, int quantity) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(quantity);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrderListByUserIDandQuantity(int userID, int offset, int quantity) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.eq("userId", userID));
		criteria.setFirstResult(offset);
		criteria.setMaxResults(quantity);
		return criteria.list();
	}
	
	public boolean checkExistenceByUserID(int userID, int orderID) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.idEq(orderID));
		criteria.add(Restrictions.eq("userId", userID));
		return criteria.uniqueResult() != null;
	}
}