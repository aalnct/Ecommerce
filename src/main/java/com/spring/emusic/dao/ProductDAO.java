package com.spring.emusic.dao;

import java.util.List;

import com.spring.emusic.model.Product;

public interface ProductDAO {
	
	public void addProduct(Product producct);
	
	/*
	 * 
	 */
	public Product getProductById(String id);
	
	
	/*
	 * 
	 */
	
	public List<Product> getAllProducts();
	
	/*
	 * 
	 */
	public void deleteProduct(String id);
	
	
	/*
	 * 
	 */
	public void editProduct(Product product);
	
}
