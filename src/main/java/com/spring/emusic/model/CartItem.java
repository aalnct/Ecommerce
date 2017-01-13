package com.spring.emusic.model;

public class CartItem {
	
	
	private Product product;
	
	private int quantity;
	
	private double totalPrice;
	
	
	public CartItem(){
		
	}
	
	public CartItem(Product product, int quantity, double totalPrice){
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
