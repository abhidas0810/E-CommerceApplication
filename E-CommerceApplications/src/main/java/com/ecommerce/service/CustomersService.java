package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.model.Customers;
import com.ecommerce.model.Feedback;

public interface CustomersService {

	public Customers addCustomer(Customers customer) throws CustomerException;

	public Customers deleteCustomer(Integer customerId) throws CustomerException;

	public Customers getCustomerByID(Integer customerId) throws CustomerException;

	public List<Customers> getAllCustomers() throws CustomerException;

	public List<Feedback> addFeedbackOnCustomer(Integer customerId, Feedback feedback)
			throws CustomerException, FeedbackException;

}
