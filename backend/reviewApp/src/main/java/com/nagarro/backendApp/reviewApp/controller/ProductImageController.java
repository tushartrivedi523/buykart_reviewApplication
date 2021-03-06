package com.nagarro.backendApp.reviewApp.controller;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.backendApp.reviewApp.model.ProductImage;
import com.nagarro.backendApp.reviewApp.model.ProductList;
import com.nagarro.backendApp.reviewApp.repository.ProductImageRepo;
import com.nagarro.backendApp.reviewApp.repository.ProductListRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductImageController {
	
	@Autowired
	ProductImageRepo productimagerepo;
	
	@GetMapping("productImage/{productid}")
	public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("productid") long id) 
	        throws SQLException {

		Optional<ProductImage> product  = productimagerepo.findById(id);
		byte[] imageBytes = null;
		if (product.isPresent()) {
		
			imageBytes = product.get().getProductimagedata().getBytes(1,
						(int) product.get().getProductimagedata().length());
		}
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
	

}
