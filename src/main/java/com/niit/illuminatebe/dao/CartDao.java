package com.niit.illuminatebe.dao;

import java.util.List;

import com.niit.illuminatebe.model.Cart;

public interface CartDao {

	public List<Cart> getCartList(String username);

	public boolean save(Cart cart);

	public boolean delete(Cart cart);

	public boolean update(Cart cart);

	public int getQuantity(String username, String productname);

	public long getTotalAmount(String username);

	public Cart getCartByUsername(String username, String productname);

	public long getNumberOfProducts(String username);

}
