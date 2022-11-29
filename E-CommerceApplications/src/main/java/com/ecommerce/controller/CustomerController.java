package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.model.Customers;
import com.ecommerce.model.Feedback;
import com.ecommerce.service.CustomersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController {

	@Autowired
	private CustomersService customersService;

	/*--------------------------------------------Customer Controller--------------------------- */

	@PostMapping("/customer")
	public ResponseEntity<Customers> addCustomerHandler(@RequestBody Customers customer) throws CustomerException {
		return new ResponseEntity<Customers>(customersService.addCustomer(customer), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customers> deleteCustomerHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException {
		return new ResponseEntity<Customers>(customersService.deleteCustomer(customerId), HttpStatus.OK);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customers> getCustomerByIdHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException {
		return new ResponseEntity<Customers>(customersService.getCustomerByID(customerId), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customers>> getAllCustomersHandler() throws CustomerException {
		return new ResponseEntity<List<Customers>>(customersService.getAllCustomers(), HttpStatus.OK);
	}

	@PostMapping("/customer/addfeedback/{customerId}")
	public ResponseEntity<List<Feedback>> addFeedbackOnCustomerHandler(@PathVariable("customerId") Integer customerId,
			@RequestBody Feedback feedback) throws CustomerException, FeedbackException {
		return new ResponseEntity<List<Feedback>>(customersService.addFeedbackOnCustomer(customerId, feedback),
				HttpStatus.ACCEPTED);
	}

}
