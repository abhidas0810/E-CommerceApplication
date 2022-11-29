package com.ecommerce.exception;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.CurrentUserSession;
import com.ecommerce.model.Customers;
import com.ecommerce.model.LoginDTO;
import com.ecommerce.repository.CurrentUserSessionRepo;
import com.ecommerce.repository.CustomersRepo;
import com.ecommerce.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomersRepo cRepo;
	
	@Autowired
	private CurrentUserSessionRepo userRepo;
	
	@Override
	public String customerLogin(LoginDTO dto) throws LoginException {
		
		Customers existingCustomer =  cRepo.findByEmail(dto.getEmail());
		
		if (existingCustomer == null) {
			throw new LoginException("Invalid Email Id..");
		}
		
		Optional<CurrentUserSession> existingSession = userRepo.findById(existingCustomer.getCustomerId());
		
		if (existingSession.isPresent()) {
			throw new LoginException("User is already logged in with this Email ID..");
		}
		
		if (existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key = RandomString.make(6);
			
			CurrentUserSession currentSession = new CurrentUserSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			
			userRepo.save(currentSession);
			
			return key;
		}else {
			throw new LoginException("Password is incorrect..");
		}
		
		
	}

	@Override
	public String customerLogout(String key) throws LoginException {
		
		CurrentUserSession result =  userRepo.findBySessionKey(key);
		
		if (result == null) {
			throw new LoginException("Please provide valid session key");
		}
		
		userRepo.delete(result);
		
		return "Logout successfull..";
		
	}

}
