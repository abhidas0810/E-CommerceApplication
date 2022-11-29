package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}
