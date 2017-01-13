package com.spring.emusic.service;

import com.spring.emusic.model.CartItem;

public interface CartItemService {
	
	
	public void addProduct(CartItem item);
	public void removeProduct(CartItem item);

}
