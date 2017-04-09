package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.CartDao;
import com.niit.illuminatebe.model.Cart;
import com.niit.illuminatebe.service.CartService;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public List<Cart> getCartList(String username) {
		// TODO Auto-generated method stub
		return cartDao.getCartList(username);
	}

	@Override
	public boolean save(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.save(cart);
	}

	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.delete(cart);
	}

	@Override
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.update(cart);
	}

	@Override
	public long getTotalAmount(String username) {
		// TODO Auto-generated method stub
		return cartDao.getTotalAmount(username);
	}

	@Override
	public Cart getCartByUsername(String username, String productname) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUsername(username, productname);
	}

	@Override
	public int getQuantity(String username, String productname) {
		// TODO Auto-generated method stub
		return cartDao.getQuantity(username, productname);
	}

	@Override
	public long getNumberOfProducts(String username) {
		// TODO Auto-generated method stub
		return cartDao.getNumberOfProducts(username);
	}

}
