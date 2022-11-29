package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.PaymentException;
import com.ecommerce.model.Payments;

public interface PaymentsService {

	public Payments makePayment(Payments payment, Integer orderId, Integer customerId)
			throws PaymentException, OrdersException, CustomerException;

	public Payments getPaymentByID(Integer paymentId) throws PaymentException;

	public List<Payments> getAllPayments() throws PaymentException;

}
