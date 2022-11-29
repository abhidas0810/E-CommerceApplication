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
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepo;
	@Autowired
	private CustomersRepo customersRepo;

	@Override
	public Feedback addFeedback(Feedback feedback) throws FeedbackException {
		Feedback feedback2 = feedbackRepo.save(feedback);
		if (feedback2 == null) {
			throw new FeedbackException("Feedback can not be added.");
		}
		return feedback2;
	}

	@Override
	public Feedback deleteFeedback(Integer feedbackId) throws FeedbackException {
		Feedback feedback = feedbackRepo.findById(feedbackId)
				.orElseThrow(() -> new FeedbackException("Feedback not found with feedbackId : " + feedbackId));
		feedbackRepo.delete(feedback);
		return feedback;
	}

	@Override
	public Feedback getFeedbackByID(Integer feedbackId) throws FeedbackException {
		Feedback feedback = feedbackRepo.findById(feedbackId)
				.orElseThrow(() -> new FeedbackException("Feedback not found with feedbackId : " + feedbackId));
		return feedback;
	}

	@Override
	public List<Feedback> getAllFeedbacks() throws FeedbackException {
		List<Feedback> feedbacks = feedbackRepo.findAll();
		if (feedbacks.isEmpty()) {
			throw new FeedbackException("No feedback found.");
		}
		return feedbacks;
	}

	@Override
	public List<Feedback> getFeedbacksByCustomerId(Integer customerId) throws FeedbackException, CustomerException {
		Customers customer = customersRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("Customer not found with customerId : " + customerId));
		return customer.getFeedbacks();
	}

}
