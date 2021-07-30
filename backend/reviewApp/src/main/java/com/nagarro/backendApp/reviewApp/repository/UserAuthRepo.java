package com.nagarro.backendApp.reviewApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.backendApp.reviewApp.model.UserAuth;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
	
}
