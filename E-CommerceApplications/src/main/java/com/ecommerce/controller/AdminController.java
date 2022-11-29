package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.AdminException;
import com.ecommerce.model.Admin;
import com.ecommerce.service.AdminService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	/*--------------------------------------------Admin Controller--------------------------- */

	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdminHandler(@RequestBody Admin admin) throws AdminException {

		return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.ACCEPTED);
	}

	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAllAdminsHandler() throws AdminException {

		return new ResponseEntity<List<Admin>>(adminService.getAllAdmins(), HttpStatus.OK);
	}

}
