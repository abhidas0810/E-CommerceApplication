package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.AdminException;
import com.ecommerce.model.Admin;
import com.ecommerce.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		Admin admin2 = adminRepo.save(admin);
		if (admin2 == null) {
			throw new AdminException("Admin cannot be added.");
		}
		return admin2;
	}

	@Override
	public List<Admin> getAllAdmins() throws AdminException {
		List<Admin> admins = adminRepo.findAll();
		if (admins.isEmpty()) {
			throw new AdminException("No admin found.");
		}
		return admins;
	}

}
