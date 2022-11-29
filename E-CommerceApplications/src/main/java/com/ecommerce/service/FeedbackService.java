package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback) throws FeedbackException;

	public Feedback deleteFeedback(Integer feedbackId) throws FeedbackException;

	public Feedback getFeedbackByID(Integer feedbackId) throws FeedbackException;

	public List<Feedback> getAllFeedbacks() throws FeedbackException;

	public List<Feedback> getFeedbacksByCustomerId(Integer customerId) throws FeedbackException, CustomerException;

}
