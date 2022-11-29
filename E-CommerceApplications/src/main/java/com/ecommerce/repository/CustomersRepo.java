package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Customers;

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Integer> {
	public Customers findByEmail(String email);
}
