package com.spring.emusic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.emusic.model.Product;

@Repository
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
