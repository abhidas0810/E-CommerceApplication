package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.model.Customers;
import com.ecommerce.model.Feedback;
import com.ecommerce.repository.CustomersRepo;
import com.ecommerce.repository.FeedbackRepo;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	private CustomersRepo customersRepo;
	@Autowired
	private FeedbackRepo feedbackRepo;

	@Override
	public Customers addCustomer(Customers customer) throws CustomerException {
		Customers customers = customersRepo.save(customer);
		if (customers == null) {
			throw new CustomerException("Customer can not be added.");
		}
		return customers;
	}

	@Override
	public Customers deleteCustomer(Integer customerId) throws CustomerException {
		Customers customer = customersRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with customerId : " + customerId));
		customersRepo.delete(customer);
		return customer;
	}

	@Override
	public Customers getCustomerByID(Integer customerId) throws CustomerException {
		Customers customer = customersRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with customerId : " + customerId));
		return customer;
	}

	@Override
	public List<Customers> getAllCustomers() throws CustomerException {
		List<Customers> customers = customersRepo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerException("No customer found.");
		}
		return customers;
	}

	@Override
	public List<Feedback> addFeedbackOnCustomer(Integer customerId, Feedback feedback)
			throws CustomerException, FeedbackException {
		Customers customer = customersRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with customerId : " + customerId));
		feedback.setCustomer(customer);
		Feedback feedback2 = feedbackRepo.save(feedback);
		if (feedback2 == null) {
			throw new FeedbackException("Feedback can not be added.");
		}
		customer.getFeedbacks().add(feedback2);
		customersRepo.save(customer);
		return customer.getFeedbacks();
	}

}
