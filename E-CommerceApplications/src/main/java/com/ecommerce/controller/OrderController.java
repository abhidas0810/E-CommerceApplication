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

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Orders;
import com.ecommerce.service.OrdersService;

@RestController
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;

	/*--------------------------------------------Order Controller--------------------------- */
	
	@PostMapping("/order")
	public ResponseEntity<Orders> addOrdersHandler(@RequestBody Orders order, @RequestParam Integer customerId) throws OrdersException, CustomerException{
		Orders ord = ordersService.addOrder(order, customerId);
		
		return new ResponseEntity<Orders>(ord,HttpStatus.OK);
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<Orders> deleteOrderHandler(@RequestParam Integer orderId) throws OrdersException{
		Orders ord = ordersService.deleteOrder(orderId);
		
		return new ResponseEntity<Orders>(ord,HttpStatus.OK);
	}
	
	@GetMapping("/order")
	public ResponseEntity<Orders> getOrderByIdHandler(@RequestParam Integer orderId) throws OrdersException{
		Orders ord = ordersService.getOrderById(orderId);
		
		return new ResponseEntity<Orders>(ord,HttpStatus.OK);
	}
	
	@PostMapping("/addProducts")
	public ResponseEntity<Orders> addProductsHandler(@RequestParam Integer orderId,@RequestParam Integer productId) throws OrdersException, ProductException{
		Orders ord = ordersService.addProducts(orderId, productId);
		
		return new ResponseEntity<Orders>(ord,HttpStatus.OK);
	}
	
	@GetMapping("/allorders")
	public ResponseEntity<List<Orders>> getAllOrdersHandler() throws OrdersException{
		List<Orders> oList = ordersService.getAllOrders();
		
		return new ResponseEntity<List<Orders>>(oList,HttpStatus.OK);
	}
}
