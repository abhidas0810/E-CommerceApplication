package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.LoginException;
import com.ecommerce.model.LoginDTO;
import com.ecommerce.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/customerLogin")
	public ResponseEntity<String> customerLoginHandler(@RequestBody LoginDTO dto) throws LoginException {
		String res = loginService.customerLogin(dto);

		return new ResponseEntity<String>(res, HttpStatus.ACCEPTED);
	}

	@GetMapping("/customerLogout")
	public ResponseEntity<String> customerLogOutHandler(@RequestParam String key) throws LoginException {
		String res = loginService.customerLogout(key);

		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
}
