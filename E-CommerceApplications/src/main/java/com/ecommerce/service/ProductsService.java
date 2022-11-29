package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Products;

public interface ProductsService {

	public Products addProduct(Products product) throws ProductException;

	public Products daleteProduct(Integer productId) throws ProductException;

	public Products getProductById(Integer productId) throws ProductException;

	public List<Products> getAllProducts() throws ProductException;

	public List<Products> getProductsByName(String productName) throws ProductException;

	public List<Products> getProductsByType(String productType) throws ProductException;

	public List<Products> getProductsByCategory(String categoryName) throws ProductException, CategoryException;

}
