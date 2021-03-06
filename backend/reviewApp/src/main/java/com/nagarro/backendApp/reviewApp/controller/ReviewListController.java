package com.nagarro.backendApp.reviewApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.backendApp.reviewApp.model.ProductList;
import com.nagarro.backendApp.reviewApp.model.ReviewList;
import com.nagarro.backendApp.reviewApp.repository.ReviewListRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReviewListController {

	@Autowired
	ReviewListRepo reviewlistrepo;
	
	@GetMapping("/reviewList")
	public ResponseEntity<List<ReviewList>> reviewStats(){
		List<ReviewList> reviewList = new ArrayList<>();
		reviewlistrepo.findAll().forEach(reviewList::add);
		if(reviewList.size()==0)
		{
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(reviewList,HttpStatus.OK);
	}
	
	@GetMapping("/reviewList/{productid}")
	public ResponseEntity<List<ReviewList>> getAllReviewById( @PathVariable("productid") long id ){
				
		List<ReviewList> reviewList = new ArrayList<ReviewList>();
		List<ReviewList> finalList = new ArrayList<ReviewList>();
		reviewlistrepo.findAll().forEach(reviewList::add);
		for(ReviewList review : reviewList)
		{
			if(review.getProductId()==id)
			{
				finalList.add(review);
			}
		}
		if(finalList.size()==0)
		{
		return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(finalList, HttpStatus.OK);
	}
	
	@PostMapping("/reviewList")
	public ResponseEntity<Boolean> addReview(@RequestBody ReviewList review)
	{
		ReviewList addreview = new ReviewList(review.getProductId(),review.getReviewTitle(),
											  review.getReviewContent(),review.getUserName());
		reviewlistrepo.save(addreview);
		return new ResponseEntity<>(true, HttpStatus.OK);				
	}
	
}
