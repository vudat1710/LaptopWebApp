package com.group14.project.web.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group14.project.web.beans.Order;
import com.group14.project.web.beans.OrderStatus;

@Repository
@Transactional
@Component("orderDao")
public class OrderDao {
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Order getOrderByOrderID(int orderID) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.idEq(orderID));
		return (Order) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrderListBySearchElements(String orderID, String userID, String orderDate, String shipDate) throws ParseException {
		Criteria criteria = getSession().createCriteria(Order.class);
		if (!orderID.isEmpty()) {
			criteria.add(Restrictions.idEq(Integer.parseInt(orderID)));
		}
		if (!userID.isEmpty()) {
			criteria.add(Restrictions.eq("userId",Integer.parseInt(userID)));
		}
		if (!orderDate.isEmpty()) {
			criteria.add(Restrictions.eq("orderDate", simpleDateFormat.parse(orderDate)));
		}
		if (!shipDate.isEmpty()) {
			criteria.add(Restrictions.eq("shipDate", simpleDateFormat.parse(shipDate)));
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
	
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		Criteria criteria = getSession().createCriteria(Order.class);
		return criteria.list();
	}
	
	public void updateOrder(Order order) {
		getSession().update(order);
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrderListByUserId(int userId) {
		Criteria criteria = getSession().createCriteria(Order.class);
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}
}
