package com.group14.project.web.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.beans.Order;
import com.group14.project.web.beans.OrdersDetail;
import com.group14.project.web.beans.User;
import com.group14.project.web.dao.OrderDao;
import com.group14.project.web.dao.OrdersDetailDao;
import com.group14.project.web.dao.UserDao;
import com.group14.project.web.model.OrderDetail;
import com.group14.project.web.model.OrderDetailItem;

@Service("orderService")
public class OrderService {
	private static final int NO_ORDER_PER_PAGE = 15;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrdersDetailDao ordersDetailDao;
	
	@Autowired
	private UserDao userDao; 
	
	public Order getOrderByOrderID(int orderID) {
		return orderDao.getOrderByOrderID(orderID);
	}
	
	public List<Order> getOrderListBySearchElements(String orderID, String userID, String orderDate, String shipDate) throws ParseException {
		return orderDao.getOrderListBySearchElements(orderID, userID, orderDate, shipDate);
	}
	
	public List<Order> getOrderListByOffsetQuantity(int offset, int quantity) {
		return orderDao.getOrderListByOffsetQuantity(offset, quantity);
	}
	
	public List<Order> getOrderListByPage(int page) {
		return orderDao.getOrderListByOffsetQuantity(page * NO_ORDER_PER_PAGE, NO_ORDER_PER_PAGE);
	}
	
	public List<Order> searchOrderListByPageAndUserID(String userID, int page) {
		return orderDao.getOrderListByUserIDandQuantity(Integer.parseInt(userID), page * NO_ORDER_PER_PAGE, NO_ORDER_PER_PAGE);
	}
	
	public List<OrderDetailItem> getOrderDetailItems(List<OrdersDetail> ordersDetails) {
		List<OrderDetailItem> orderDetailItems = new ArrayList<>();
		for (OrdersDetail ordersDetail: ordersDetails) {
			orderDetailItems.add(new OrderDetailItem(ordersDetail));
		}
		return orderDetailItems;
	}
	
	public OrderDetail getOrderDetailByOrderID(int orderID) {
		int userID = orderDao.getUserIdByOrderId(orderID);
		
		Order order = orderDao.getOrderByOrderID(orderID);
		User user = (User) userDao.searchUserByUserIdUsernameName(Integer.toString(userID), "", "");
		
		List<OrdersDetail> ordersDetails = ordersDetailDao.getOrderDetailByOrderID(orderID);
		List<OrderDetailItem> orderDetailItems = getOrderDetailItems(ordersDetails);
		return new OrderDetail(user, order, orderDetailItems);
	}
}
