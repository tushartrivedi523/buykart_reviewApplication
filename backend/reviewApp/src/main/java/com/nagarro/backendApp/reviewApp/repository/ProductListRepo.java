package com.nagarro.backendApp.reviewApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.backendApp.reviewApp.model.ProductList;

@Repository
public interface ProductListRepo extends JpaRepository<ProductList, Long> {

}
