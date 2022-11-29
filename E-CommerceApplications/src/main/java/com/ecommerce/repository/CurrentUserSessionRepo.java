package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.CurrentUserSession;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {
	public CurrentUserSession findBySessionKey(String sessionkey);
}
