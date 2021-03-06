package com.nagarro.backendApp.reviewApp.model;

import javax.persistence.*;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name="productlist")
public class ProductList {

	@Id
	@Column(name="productid")
	long productid;
	@Column(name="productname")
	String productname;
	@Column(name="productprice")
	long productprice;
	@Column(name="productbrand")
	String brand;
	@Column(name="productdetail")
	String productdetail;
//	@Column(name="productimage")
//	java.sql.Blob productimage;
//	
//	
	
	
	
	
//	public java.sql.Blob getProductimage() {
//		return productimage;
//	}
//	public void setProductimage(java.sql.Blob productimage) {
//		this.productimage = productimage;
//	}
	public String getProductdetail() {
		return productdetail;
	}
	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public long getProductprice() {
		return productprice;
	}
	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}
	
	
	public ProductList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductList(String productname, long productprice) {
		super();
		this.productname = productname;
		this.productprice = productprice;
	}
	
	@Override
	public String toString() {
		return "ProductList [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
				+ "]";
	}
	
	
	
}
