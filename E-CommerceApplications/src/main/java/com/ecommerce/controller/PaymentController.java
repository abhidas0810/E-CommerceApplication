package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.PaymentException;
import com.ecommerce.model.Payments;
import com.ecommerce.service.PaymentsService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentsService paymentsService;

	/*--------------------------------------------Payment Controller--------------------------- */

	@PostMapping("/payment/{orderId}/{customerId}")
	public ResponseEntity<Payments> makePaymentHandler(@RequestBody Payments payment,
			@PathVariable("orderId") Integer orderId, @PathVariable("customerId") Integer customerId)
			throws PaymentException, OrdersException, CustomerException {
		return new ResponseEntity<Payments>(paymentsService.makePayment(payment, orderId, customerId),
				HttpStatus.CREATED);
	}

	@GetMapping("/payment/{paymentId}")
	public ResponseEntity<Payments> getPaymentByIdHandler(@PathVariable("paymentId") Integer paymentId)
			throws PaymentException {
		return new ResponseEntity<Payments>(paymentsService.getPaymentByID(paymentId), HttpStatus.OK);
	}

	@GetMapping("/payments")
	public ResponseEntity<List<Payments>> getAllPaymentsHandler() throws PaymentException {
		return new ResponseEntity<List<Payments>>(paymentsService.getAllPayments(), HttpStatus.OK);
	}

}
