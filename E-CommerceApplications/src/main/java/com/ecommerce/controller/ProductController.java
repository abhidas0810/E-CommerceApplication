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
import com.ecommerce.model.Products;
import com.ecommerce.repository.ProductsRepo;
import com.ecommerce.service.ProductsService;

@RestController
public class ProductController {

	@Autowired
	private ProductsService productsService;

	/*--------------------------------------------Product Controller--------------------------- */
	
	@PostMapping("/product")
	public ResponseEntity<Products> addProductHandler(@RequestBody Products product) throws ProductException {
		Products prod = productsService.addProduct(product);

		return new ResponseEntity<Products>(prod, HttpStatus.OK);
	}

	@DeleteMapping("/product")
	public ResponseEntity<Products> deleteProductHandler(@RequestParam Integer productId) throws ProductException {
		Products prod = productsService.daleteProduct(productId);

		return new ResponseEntity<Products>(prod, HttpStatus.OK);
	}

	@GetMapping("/product")
	public ResponseEntity<Products> getProductByIdHandler(@RequestParam Integer productId) throws ProductException {
		Products prod = productsService.getProductById(productId);

		return new ResponseEntity<Products>(prod, HttpStatus.OK);
	}

	@GetMapping("/allProducts")
	public ResponseEntity<List<Products>> getAllProductsHandler() throws ProductException {
		List<Products> list = productsService.getAllProducts();

		return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
	}

	@GetMapping("/productByName")
	public ResponseEntity<List<Products>> getProductsByNameHandler(@RequestParam String productName)
			throws ProductException {
		List<Products> list = productsService.getProductsByName(productName);

		return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
	}

	@GetMapping("/productByType")
	public ResponseEntity<List<Products>> getProductsByTypeHandler(String productType) throws ProductException {
		List<Products> list = productsService.getProductsByType(productType);

		return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
	}

	@GetMapping("/productCategory")
	public ResponseEntity<List<Products>> getProductsByCategoryHandler(String categoryName)
			throws ProductException, CategoryException {
		List<Products> list = productsService.getProductsByCategory(categoryName);

		return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
	}

}
