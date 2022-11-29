package com.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull
	private Orders order;
	@ManyToOne(cascade = CascadeType.ALL)
	@NotNull
	private Customers customer;
	@NotNull
	private String status;
	@NotNull
	private String paymentMode;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Payments() {
		// TODO Auto-generated constructor stub
	}

	public Payments(Integer paymentId, @NotNull Orders order, @NotNull Customers customer, @NotNull String status,
			@NotNull String paymentMode) {
		super();
		this.paymentId = paymentId;
		this.order = order;
		this.customer = customer;
		this.status = status;
		this.paymentMode = paymentMode;
	}

	public Payments(@NotNull Orders order, @NotNull Customers customer, @NotNull String status,
			@NotNull String paymentMode) {
		super();
		this.order = order;
		this.customer = customer;
		this.status = status;
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "Payments [paymentId=" + paymentId + ", order=" + order + ", customer=" + customer + ", status=" + status
				+ ", paymentMode=" + paymentMode + "]";
	}

}
