package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String brand;
	private String type;
	private Integer marketPrice;
	private Integer purchasePrice;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Category> categories = new ArrayList<>();
	@ManyToOne(cascade = CascadeType.ALL)
	private Orders order;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Integer marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Integer getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(Integer productId, String productName, String brand, String type, Integer marketPrice,
			Integer purchasePrice, List<Category> categories, Orders order) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.type = type;
		this.marketPrice = marketPrice;
		this.purchasePrice = purchasePrice;
		this.categories = categories;
		this.order = order;
	}

	public Products(String productName, String brand, String type, Integer marketPrice, Integer purchasePrice,
			List<Category> categories, Orders order) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.type = type;
		this.marketPrice = marketPrice;
		this.purchasePrice = purchasePrice;
		this.categories = categories;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", type="
				+ type + ", marketPrice=" + marketPrice + ", purchasePrice=" + purchasePrice + ", order=" + order + "]";
	}

}
