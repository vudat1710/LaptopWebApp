package com.group14.project.web.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.beans.Order;
import com.group14.project.web.beans.OrderStatus;
import com.group14.project.web.beans.OrdersDetail;
import com.group14.project.web.beans.Product;
import com.group14.project.web.beans.User;
import com.group14.project.web.dao.OrderDao;
import com.group14.project.web.dao.OrdersDetailDao;
import com.group14.project.web.dao.ProductDao;
import com.group14.project.web.dao.UserDao;
import com.group14.project.web.model.OrdersDetailModel;
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
	
	@Autowired
	private ProductDao productDao;
	
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
			Product product = productDao.getProductByProductId(ordersDetail.getProductId());
			orderDetailItems.add(new OrderDetailItem(ordersDetail, product));
		}
		return orderDetailItems;
	}
	
	public OrdersDetailModel getOrderDetailByOrderID(int orderID) {		
		Order order = orderDao.getOrderByOrderID(orderID);
		User user = userDao.getUserByUserId(Integer.toString(order.getUserId()));
		
		List<OrdersDetail> ordersDetails = ordersDetailDao.getOrderDetailByOrderID(orderID);
		List<OrderDetailItem> orderDetailItems = getOrderDetailItems(ordersDetails);
		return new OrdersDetailModel(user, order, orderDetailItems);
	}
	
	public List<OrdersDetailModel> getAllOrderDetail() {
		List<OrdersDetailModel> ordersDetailModels = new ArrayList<>();
		List<OrdersDetail> ordersDetails = ordersDetailDao.getAllOrderDetail();
		for (OrdersDetail oDetail : ordersDetails) {
			OrdersDetailModel orderDetail = getOrderDetailByOrderID(oDetail.getOrderId());
			ordersDetailModels.add(orderDetail);
		}
		return ordersDetailModels;
	}
	
//	public List<OrdersDetailModel> getOrderDetailListByOrderId(int orderID) {
//		List<OrdersDetailModel> ordersDetailModels = new ArrayList<>();
//		List<OrdersDetail> ordersDetails = ordersDetailDao.getOrderDetailByOrderID(orderID);
//		for (OrdersDetail oDetail : ordersDetails) {
//			OrdersDetailModel oModel = getOrderDetailByOrderID(orderID);
//			ordersDetailModels.add();
//		}
//	}
	
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}
	
	public List<Order> getOrderListByUserId(int userId) {
		return orderDao.getOrderListByUserId(userId);
	}
}
