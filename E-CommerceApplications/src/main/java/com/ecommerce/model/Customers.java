package com.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	private String phone;
	@Email
	@Column(unique = true)
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Payments> payment;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders> order;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Feedback> feedbacks = new ArrayList<>();

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Payments> getPayment() {
		return payment;
	}

	public void setPayment(List<Payments> payment) {
		this.payment = payment;
	}

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(Integer customerId, String firstName, String lastName, String city, String state, String phone,
			@Email String email, String password, List<Payments> payment, List<Orders> order,
			List<Feedback> feedbacks) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.payment = payment;
		this.order = order;
		this.feedbacks = feedbacks;
	}

	public Customers(String firstName, String lastName, String city, String state, String phone, @Email String email,
			String password, List<Payments> payment, List<Orders> order, List<Feedback> feedbacks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.payment = payment;
		this.order = order;
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", city="
				+ city + ", state=" + state + ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}

}
