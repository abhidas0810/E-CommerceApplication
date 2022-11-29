package com.ecommerce.service;

import com.ecommerce.exception.LoginException;
import com.ecommerce.model.LoginDTO;

public interface LoginService {
	
	public String customerLogin(LoginDTO dto) throws LoginException;
	public String customerLogout(String key) throws LoginException;
}
