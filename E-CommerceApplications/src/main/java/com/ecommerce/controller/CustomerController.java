package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.CategoryException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.PaymentException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Category;
import com.ecommerce.model.Customers;
import com.ecommerce.model.Feedback;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Payments;
import com.ecommerce.model.Products;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.CustomersService;
import com.ecommerce.service.FeedbackService;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.PaymentsService;
import com.ecommerce.service.ProductsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController {

	@Autowired
	private CustomersService customersService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private PaymentsService paymentsService;
	@Autowired
	private ProductsService productsService;

	/*--------------------------------------------Customer Controller--------------------------- */

	@PostMapping("/customer")
	public ResponseEntity<Customers> addCustomerHandler(@RequestBody Customers customer) throws CustomerException {
		return new ResponseEntity<Customers>(customersService.addCustomer(customer), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customers> deleteCustomerHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException {
		return new ResponseEntity<Customers>(customersService.deleteCustomer(customerId), HttpStatus.OK);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<Customers> getCustomerByIdHandler(@PathVariable("customerId") Integer customerId)
			throws CustomerException {
		return new ResponseEntity<Customers>(customersService.getCustomerByID(customerId), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customers>> getAllCustomersHandler() throws CustomerException {
		return new ResponseEntity<List<Customers>>(customersService.getAllCustomers(), HttpStatus.OK);
	}

	@PostMapping("/customer/addfeedback/{customerId}")
	public ResponseEntity<List<Feedback>> addFeedbackOnCustomerHandler(@PathVariable("customerId") Integer customerId,
			@RequestBody Feedback feedback) throws CustomerException, FeedbackException {
		return new ResponseEntity<List<Feedback>>(customersService.addFeedbackOnCustomer(customerId, feedback),
				HttpStatus.ACCEPTED);
	}

	/*--------------------------------------------Category Controller--------------------------- */

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<Category> getCategoryByIdHandler(@PathVariable("categoryId") Integer categoryId)
			throws CategoryException {
		Category cat = categoryService.getCategoryByID(categoryId);

		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}

	@GetMapping("/categorys")
	public ResponseEntity<List<Category>> getAllCategoriesHandler() throws CategoryException {
		List<Category> allCats = categoryService.getAllCategories();

		return new ResponseEntity<List<Category>>(allCats, HttpStatus.OK);
	}

	/*--------------------------------------------Feedback Controller--------------------------- */

	@PostMapping("/feedback")
	public ResponseEntity<Feedback> addFeedbackHandler(@RequestBody Feedback feedback) throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback), HttpStatus.CREATED);
	}

	@DeleteMapping("/feedback/{feedbackId}")
	public ResponseEntity<Feedback> deleteFeedbackHandler(@PathVariable("feedbackId") Integer feedbackId)
			throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.deleteFeedback(feedbackId), HttpStatus.OK);
	}

	@GetMapping("/feedback/{feedbackId}")
	public ResponseEntity<Feedback> getFeedbackByIdHandler(@PathVariable("feedbackId") Integer feedbackId)
			throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.getFeedbackByID(feedbackId), HttpStatus.OK);
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacksHandler() throws FeedbackException {
		return new ResponseEntity<List<Feedback>>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
	}

	@GetMapping("/feedback/customer/{customerId}")
	public ResponseEntity<List<Feedback>> getFeedbacksByCustomerIdHandler(
			@PathVariable("customerId") Integer customerId) throws FeedbackException, CustomerException {
		return new ResponseEntity<List<Feedback>>(feedbackService.getFeedbacksByCustomerId(customerId), HttpStatus.OK);
	}

	/*--------------------------------------------Order Controller--------------------------- */

	@PostMapping("/order/{customerId}")
	public ResponseEntity<Orders> addOrdersHandler(@RequestBody Orders order,
			@PathVariable("customerId") Integer customerId) throws OrdersException, CustomerException {
		Orders ord = ordersService.addOrder(order, customerId);

		return new ResponseEntity<Orders>(ord, HttpStatus.OK);
	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<Orders> deleteOrderHandler(@PathVariable("orderId") Integer orderId) throws OrdersException {
		Orders ord = ordersService.deleteOrder(orderId);

		return new ResponseEntity<Orders>(ord, HttpStatus.OK);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Orders> getOrderByIdHandler(@PathVariable("orderId") Integer orderId) throws OrdersException {
		Orders ord = ordersService.getOrderById(orderId);

		return new ResponseEntity<Orders>(ord, HttpStatus.OK);
	}

	@PostMapping("/addProducts/{orderId}/{productId}")
	public ResponseEntity<Orders> addProductsHandler(@PathVariable("orderId") Integer orderId,
			@PathVariable("productId") Integer productId) throws OrdersException, ProductException {
		Orders ord = ordersService.addProducts(orderId, productId);

		return new ResponseEntity<Orders>(ord, HttpStatus.OK);
	}

	/*--------------------------------------------Payment Controller--------------------------- */

	@PostMapping("/payment/{orderId}/{customerId}")
	public ResponseEntity<Payments> makePaymentHandler(@RequestBody Payments payment,
			@PathVariable("orderId") Integer orderId, @PathVariable("customerId") Integer customerId)
			throws PaymentException, OrdersException, CustomerException {
		return new ResponseEntity<Payments>(paymentsService.makePayment(payment, orderId, customerId),
				HttpStatus.CREATED);
	}

	@GetMapping("/payment/{paymentId}")
	public ResponseEntity<Payments> getPaymentByIdHandler(@PathVariable("paymentId") Integer paymentId)
			throws PaymentException {
		return new ResponseEntity<Payments>(paymentsService.getPaymentByID(paymentId), HttpStatus.OK);
	}

	/*--------------------------------------------Product Controller--------------------------- */

	@GetMapping("/product/{productId}")
	public ResponseEntity<Products> getProductByIdHandler(@PathVariable("productId") Integer productId)
			throws ProductException {
		Products prod = productsService.getProductById(productId);

		return new ResponseEntity<Products>(prod, HttpStatus.OK);
	}

	@GetMapping("/allProducts")
	public ResponseEntity<List<Products>> getAllProductsHandler() throws ProductException {
		List<Products> list = productsService.getAllProducts();

		return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
	}

	@GetMapping("/productByName/{productName}")
	public ResponseEntity<List<Products>> getProductsByNameHandler(@PathVariable("productName") String productName)
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
