package com.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;
	private String feedback;
	@NotNull
	private Integer rating;
	private LocalDate submitDate;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customers customer;

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackId, String feedback, @NotNull Integer rating, LocalDate submitDate,
			Customers customer) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customer;
	}

	public Feedback(String feedback, @NotNull Integer rating, LocalDate submitDate, Customers customer) {
		super();
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedback=" + feedback + ", rating=" + rating + ", submitDate="
				+ submitDate + "]";
	}

}
