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

import com.ecommerce.exception.AdminException;
import com.ecommerce.exception.CategoryException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.FeedbackException;
import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.PaymentException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.ReportException;
import com.ecommerce.model.Admin;
import com.ecommerce.model.Category;
import com.ecommerce.model.Feedback;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Payments;
import com.ecommerce.model.Products;
import com.ecommerce.model.Report;
import com.ecommerce.service.AdminService;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.FeedbackService;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.PaymentsService;
import com.ecommerce.service.ProductsService;
import com.ecommerce.service.ReportService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
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
	@Autowired
	private ReportService reportService;

	/*--------------------------------------------Admin Controller--------------------------- */

	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdminHandler(@RequestBody Admin admin) throws AdminException {

		return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.ACCEPTED);
	}

	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAllAdminsHandler() throws AdminException {

		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(), HttpStatus.OK);
	}

	/*--------------------------------------------Category Controller--------------------------- */

	@PostMapping("/category")
	public ResponseEntity<Category> addCategoryHandler(@RequestBody Category category) throws CategoryException {

		Category cat = categoryService.addCategory(category);

		return new ResponseEntity<Category>(cat, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/category/{categoryId}")
	public ResponseEntity<Category> deleteCategoryHandler(@PathVariable("categoryId") Integer categoryId)
			throws CategoryException {
		Category cat = categoryService.deleteCategory(categoryId);

		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}

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

	@PostMapping("/addCategory/{categoryId}/{productId}")
	public ResponseEntity<List<Products>> addProductsCategoryHandler(@PathVariable("categoryId") Integer categoryId,
			@PathVariable("productId") Integer productId) throws CategoryException, ProductException {

		List<Products> pList = categoryService.addProductsToCategory(categoryId, productId);

		return new ResponseEntity<List<Products>>(pList, HttpStatus.OK);
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

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Orders> getOrderByIdHandler(@PathVariable("orderId") Integer orderId) throws OrdersException {
		Orders ord = ordersService.getOrderById(orderId);

		return new ResponseEntity<Orders>(ord, HttpStatus.OK);
	}

	@GetMapping("/allorders")
	public ResponseEntity<List<Orders>> getAllOrdersHandler() throws OrdersException {
		List<Orders> oList = ordersService.getAllOrders();

		return new ResponseEntity<List<Orders>>(oList, HttpStatus.OK);
	}

	/*--------------------------------------------Payment Controller--------------------------- */

	@GetMapping("/payment/{paymentId}")
	public ResponseEntity<Payments> getPaymentByIdHandler(@PathVariable("paymentId") Integer paymentId)
			throws PaymentException {
		return new ResponseEntity<Payments>(paymentsService.getPaymentByID(paymentId), HttpStatus.OK);
	}

	@GetMapping("/payments")
	public ResponseEntity<List<Payments>> getAllPaymentsHandler() throws PaymentException {
		return new ResponseEntity<List<Payments>>(paymentsService.getAllPayments(), HttpStatus.OK);
	}

	/*--------------------------------------------Report Controller--------------------------- */

	@PostMapping("/report")
	public ResponseEntity<Report> addReportHandler(@RequestBody Report report) throws ReportException {
		return new ResponseEntity<Report>(reportService.addReport(report), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/report/{reportId}")
	public ResponseEntity<Report> deleteReportHandler(@PathVariable("reportId") Integer reportId)
			throws ReportException {
		return new ResponseEntity<Report>(reportService.deleteReport(reportId), HttpStatus.OK);
	}

	@GetMapping("/report/{reportId}")
	public ResponseEntity<Report> findByReportIdHandler(@PathVariable("reportId") Integer reportId)
			throws ReportException {
		return new ResponseEntity<Report>(reportService.findByReportId(reportId), HttpStatus.OK);
	}

	@GetMapping("/reports")
	public ResponseEntity<List<Report>> viewAllReportsHandler() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}

	/*--------------------------------------------Product Controller--------------------------- */

	@PostMapping("/product")
	public ResponseEntity<Products> addProductHandler(@RequestBody Products product) throws ProductException {
		Products prod = productsService.addProduct(product);

		return new ResponseEntity<Products>(prod, HttpStatus.OK);
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Products> deleteProductHandler(@PathVariable("productId") Integer productId)
			throws ProductException {
		Products prod = productsService.daleteProduct(productId);

		return new ResponseEntity<Products>(prod, HttpStatus.OK);
	}

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
