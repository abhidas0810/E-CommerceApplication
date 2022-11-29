package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Category;
import com.ecommerce.model.Products;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryException;

	public Category deleteCategory(Integer categoryId) throws CategoryException;

	public Category getCategoryByID(Integer categoryId) throws CategoryException;

	public List<Category> getAllCategories() throws CategoryException;

	public List<Products> addProductsToCategory(Integer categoryId, Integer productId)
			throws CategoryException, ProductException;

}
