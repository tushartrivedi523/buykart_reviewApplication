package com.nagarro.backendApp.reviewApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productimage")
public class ProductImage {
	
	@Id
	@Column(name="productid")
	long productid;
	@Column(name="productimagedata")
	java.sql.Blob productimagedata;
	
	
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public java.sql.Blob getProductimagedata() {
		return productimagedata;
	}
	public void setProductimagedata(java.sql.Blob productimagedata) {
		this.productimagedata = productimagedata;
	}
	
	
	
	

}
