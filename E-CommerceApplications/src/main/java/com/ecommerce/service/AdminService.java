package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AdminException;
import com.ecommerce.model.Admin;


public interface AdminService {

	public Admin addAdmin(Admin admin) throws AdminException;

	public List<Admin> getAllAdmins() throws AdminException;

}
