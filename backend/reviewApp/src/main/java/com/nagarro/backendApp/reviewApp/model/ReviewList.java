package com.nagarro.backendApp.reviewApp.model;

import javax.persistence.*;

@Entity
@Table(name="reviewlist")
public class ReviewList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reviewid")
	long reviewId;
	
	@Column(name="productid")
	long productId;
	
	@Column(name="reviewtitle")
	String reviewTitle;
	
	@Column(name="reviewcontent")
	String reviewContent;
	


	@Column(name="username")
	String userName;

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	
	public ReviewList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReviewList(long productId, String reviewTitle, String reviewContent, String userName) {
		super();
		this.productId = productId;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.userName = userName;
	}
	
	
	

}
