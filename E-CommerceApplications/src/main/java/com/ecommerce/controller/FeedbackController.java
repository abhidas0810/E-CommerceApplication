package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.model.Feedback;
import com.ecommerce.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	/*--------------------------------------------Feedback Controller--------------------------- */

	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedbackHandler(@RequestBody Feedback feedback) throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback), HttpStatus.CREATED);
	}

	@DeleteMapping("/feedback/{feedbackId}")
	public ResponseEntity<Feedback> deleteFeedbackHandler(@PathVariable("feedbackId") Integer feedbackId)
			throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.deleteFeedback(feedbackId), HttpStatus.OK);
	}

	@GetMapping("/feedback/{feedbackId}")
	public ResponseEntity<Feedback> getFeedbackByIdHandler(@PathVariable("feedbackId") Integer feedbackId)
			throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.getFeedbackByID(feedbackId), HttpStatus.OK);
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacksHandler() throws FeedbackException {
		return new ResponseEntity<List<Feedback>>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
	}

	@GetMapping("/feedback/customer/{customerId}")
	public ResponseEntity<List<Feedback>> getFeedbacksByCustomerIdHandler(
			@PathVariable("customerId") Integer customerId) throws FeedbackException, CustomerException {
		return new ResponseEntity<List<Feedback>>(feedbackService.getFeedbacksByCustomerId(customerId), HttpStatus.OK);
	}

}
