package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Category;
import com.ecommerce.model.Products;
import com.ecommerce.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category) throws CategoryException {

		Category cat = categoryService.addCategory(category);

		return new ResponseEntity<Category>(cat, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/category")
	public ResponseEntity<Category> deleteCategoryHandler(@RequestParam Integer categoryId) throws CategoryException {
		Category cat = categoryService.deleteCategory(categoryId);

		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}

	@GetMapping("/category")
	public ResponseEntity<Category> getCategoryByIdHandler(@RequestParam Integer categoryId) throws CategoryException {
		Category cat = categoryService.getCategoryByID(categoryId);

		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}

	@GetMapping("/categoryAll")
	public ResponseEntity<List<Category>> getAllCategoriesHandler() throws CategoryException {
		List<Category> allCats = categoryService.getAllCategories();

		return new ResponseEntity<List<Category>>(allCats, HttpStatus.OK);
	}

	@PostMapping("/addCategory")
	public ResponseEntity<List<Products>> addProductsCategoryHandler(@RequestParam Integer categoryId,
			@RequestParam Integer productId) throws CategoryException, ProductException {

		List<Products> pList = categoryService.addProductsToCategory(categoryId, productId);

		return new ResponseEntity<List<Products>>(pList, HttpStatus.OK);
	}

}
