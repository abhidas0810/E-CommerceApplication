package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Orders;

public interface OrdersService {

	public Orders addOrder(Orders orders, Integer customerId) throws OrdersException, CustomerException;

	public Orders deleteOrder(Integer orderId) throws OrdersException;

	public Orders getOrderById(Integer orderId) throws OrdersException;

	public Orders addProducts(Integer orderId, Integer productId) throws OrdersException, ProductException;

	public List<Orders> getAllOrders() throws OrdersException;

}
