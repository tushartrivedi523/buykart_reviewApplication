package com.nagarro.backendApp.reviewApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.backendApp.reviewApp.model.ReviewList;

public interface ReviewListRepo extends JpaRepository<ReviewList, Long> {
	
}
