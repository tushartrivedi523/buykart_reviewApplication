package com.nagarro.backendApp.reviewApp.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.backendApp.reviewApp.model.ProductList;
import com.nagarro.backendApp.reviewApp.model.ReviewList;
import com.nagarro.backendApp.reviewApp.repository.ProductListRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductListController {
	
	@Autowired
	ProductListRepo productlistrepo;
	
	@GetMapping("/productList")
	public ResponseEntity<List<ProductList>> getAllProduct()
	{
		List<ProductList> productList = new ArrayList<ProductList>();
		productlistrepo.findAll().forEach(productList::add);
		return new ResponseEntity<>(productList, HttpStatus.OK);	
	}
	
	
	@GetMapping("/productList/{productid}")
	public ResponseEntity<ProductList> getProductById(@PathVariable("productid") long id)
	{	
		List<ProductList> productList = new ArrayList<ProductList>();
		productlistrepo.findAll().forEach(productList::add);
		
		for(ProductList product : productList)
		{
			if(product.getProductid() == id)
			{
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	@GetMapping("/productList/searchByName/{productName}")
	public ResponseEntity<ProductList> getProductByName(@PathVariable("productName") String name)
	{
		List<ProductList> productList = new ArrayList<ProductList>();
		productlistrepo.findAll().forEach(productList::add);
		System.out.println(name);
		for(ProductList product : productList)
		{
			if(product.getProductname().equals(name))
			{
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	@GetMapping("/productList/searchByBrand/{productBrand}")
	public ResponseEntity<List<ProductList>> getProductByBrand(@PathVariable("productBrand") String brandName)
	{
		List<ProductList> productList = new ArrayList<ProductList>();
		productlistrepo.findAll().forEach(productList::add);
		System.out.println(brandName);
		List<ProductList> fetchedResultFromBrand = new ArrayList<ProductList>();
		for(ProductList product : productList)
		{
			if(product.getBrand().equals(brandName))
			{
				fetchedResultFromBrand.add(product);
			}
		}
		if(fetchedResultFromBrand.size()==0) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(fetchedResultFromBrand, HttpStatus.OK);
	}
	


}
