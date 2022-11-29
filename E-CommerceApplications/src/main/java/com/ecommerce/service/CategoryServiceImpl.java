package com.ecommerce.service;

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
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ProductsRepo productsRepo;

	@Override
	public Category addCategory(Category category) throws CategoryException {
		Category category2 = categoryRepo.save(category);
		if (category2 == null) {
			throw new CategoryException("Category can not be added.");
		}
		return category2;
	}

	@Override
	public Category deleteCategory(Integer categoryId) throws CategoryException {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryException("Category not available with categoryId : " + categoryId));
		categoryRepo.delete(category);
		return category;
	}

	@Override
	public Category getCategoryByID(Integer categoryId) throws CategoryException {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryException("Category not available with categoryId : " + categoryId));
		return category;
	}

	@Override
	public List<Category> getAllCategories() throws CategoryException {
		List<Category> categories = categoryRepo.findAll();
		if (categories.isEmpty()) {
			throw new CategoryException("There are no categories.");
		}
		return categories;
	}

	@Override
	public List<Products> addProductsToCategory(Integer categoryId, Integer productId)
			throws CategoryException, ProductException {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryException("Category not available with categoryId : " + categoryId));
		Products product = productsRepo.findById(productId)
				.orElseThrow(() -> new ProductException("Product not available with productId : " + productId));
		category.getProducts().add(product);
		product.getCategories().add(category);
		categoryRepo.save(category);
		productsRepo.save(product);
		return category.getProducts();
	}

}
