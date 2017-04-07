package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.Cart;

public interface CartService {
	public List<Cart> getCartList(int id);

	public boolean save(Cart cart);

	public boolean delete(Cart cart);

	public boolean update(Cart cart);

	public int getQuantity(String username, String productname);

	public Long getTotalAmount(int id);

	public Cart getCartByUsername(String username, String productname);
}
