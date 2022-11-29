package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Category;
import com.ecommerce.model.Products;
import com.ecommerce.repository.CategoryRepo;
import com.ecommerce.repository.ProductsRepo;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsRepo productsRepo;
	
	@Autowired
	private CategoryRepo catRepo;

	@Override
	public Products addProduct(Products product) throws ProductException {
		Products products = productsRepo.save(product);
		if (products == null) {
			throw new ProductException("Product can not be added.");
		}
		return products;
	}

	@Override
	public Products daleteProduct(Integer productId) throws ProductException {
		Products product = productsRepo.findById(productId)
				.orElseThrow(() -> new ProductException("Product not exists with productId : " + productId));
		productsRepo.delete(product);
		return product;
	}

	@Override
	public Products getProductById(Integer productId) throws ProductException {
		Products product = productsRepo.findById(productId)
				.orElseThrow(() -> new ProductException("Product not exists with productId : " + productId));
		return product;
	}

	@Override
	public List<Products> getAllProducts() throws ProductException {
		List<Products> products = productsRepo.findAll();
		if (products.isEmpty()) {
			throw new ProductException("No products exists.");
		}
		return products;
	}

	@Override
	public List<Products> getProductsByName(String productName) throws ProductException {
		List<Products> prodList = productsRepo.findByProductName(productName);
		
		if (prodList.isEmpty()) {
			throw new ProductException("No product found with this product name..");
		}
		
		return prodList;
	}

	@Override
	public List<Products> getProductsByType(String productType) throws ProductException {
		
		List<Products> prodList = productsRepo.findByType(productType);
		
		if (prodList.isEmpty()) {
			throw new ProductException("No product found for this product type");
		}
		
		return prodList;
	}

	@Override
	public List<Products> getProductsByCategory(String categoryName) throws ProductException, CategoryException {
		List<Category> catList = catRepo.findByCategoryName(categoryName);
		
		
		
		if (catList.isEmpty()) {
			throw new CategoryException("No categries found for this categories");
		}
		
		List<Products> prodList = new ArrayList<>();
		
		for (Category c: catList) {
			prodList.addAll(c.getProducts());
		}
		
		return prodList;
	}
}
