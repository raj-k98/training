package com.trg.spring.beans;

public class Product {
	private int pid;
	private String productName;
	
	private Customer customer;
	
	
	public int getProductId() {
		return pid;
	}
	public void setProductId(int productId) {
		this.pid = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Produnt Id: " + pid + "ProductName: " + productName + "\nCustomer: " + customer;
	}
	

}
