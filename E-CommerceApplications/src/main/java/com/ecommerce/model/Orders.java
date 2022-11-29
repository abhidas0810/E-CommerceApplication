package com.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	private Integer orderId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customers customer;
	@OneToOne(cascade = CascadeType.ALL)
	private Payments payment;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Products> products = new ArrayList<>();
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private Integer totalOrderAmount;
	private String orderStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Integer totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer orderId, Customers customer, Payments payment, List<Products> products, LocalDate orderDate,
			LocalDate deliveryDate, Integer totalOrderAmount, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.payment = payment;
		this.products = products;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.totalOrderAmount = totalOrderAmount;
		this.orderStatus = orderStatus;
	}

	public Orders(Customers customer, Payments payment, List<Products> products, LocalDate orderDate,
			LocalDate deliveryDate, Integer totalOrderAmount, String orderStatus) {
		super();
		this.customer = customer;
		this.payment = payment;
		this.products = products;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.totalOrderAmount = totalOrderAmount;
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customer=" + customer + ", payment=" + payment + ", orderDate="
				+ orderDate + ", deliveryDate=" + deliveryDate + ", totalOrderAmount=" + totalOrderAmount
				+ ", orderStatus=" + orderStatus + "]";
	}

}
