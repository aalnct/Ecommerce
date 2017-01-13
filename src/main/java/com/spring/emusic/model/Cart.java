package com.spring.emusic.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private String cartID;
	private Map<String,CartItem> cartItems;
	private double grandTotal;
	
	
	private Cart(){
		cartItems = new HashMap<String, CartItem>();
		grandTotal = 0;
	}
	
	
	private Cart(String cartID){
		this();
		this.cartID = cartID;
	}


	/**
	 * @return the cartID
	 */
	public String getCartID() {
		return cartID;
	}


	/**
	 * @param cartID the cartID to set
	 */
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}


	/**
	 * @return the cartItems
	 */
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}


	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	/**
	 * @return the grandTotal
	 */
	public double getGrandTotal() {
		return grandTotal;
	}


	/**
	 * @param grandTotal the grandTotal to set
	 */
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	
}
