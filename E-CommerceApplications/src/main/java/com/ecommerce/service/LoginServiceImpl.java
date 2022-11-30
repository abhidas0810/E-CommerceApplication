package com.ecommerce.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.exception.LoginException;
import com.ecommerce.model.Customers;
import com.ecommerce.model.LoginDTO;
import com.ecommerce.repository.CurrentUserSessionRepo;
import com.ecommerce.repository.CustomersRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomersRepo cRepo;
	
	@Autowired
	private CurrentUserSessionRepo sRepo;

	@Override
	public String customerLogin(LoginDTO dto) throws LoginException {
		
		Customers existingCustomer = cRepo.findByEmail(dto.getEmail());
		
		if (existingCustomer == null) {
			throw new LoginException("Enter valid email id..");
		}
		
		if (existingCustomer.getPassword().equals(dto.getPassword())) {
			String key = new RandomString().make(6);
			
			CurrentUserSession userSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			sRepo.save(userSession);
			
			return key;
		}else {
			throw new LoginException("Invalid password..");
		}
		
	}

	@Override
	public String customerLogout(String key) throws LoginException {
		CurrentUserSession currentSession = sRepo.findBySessionKey(key);
		
		if (currentSession == null) {
			throw new LoginException("Invalid session key..");
		}
		
		sRepo.delete(currentSession);
		
		return "Logged out successfully...";
	}
	
	
}
