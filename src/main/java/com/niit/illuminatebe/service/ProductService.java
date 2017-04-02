package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.Product;

public interface ProductService {
	public List<Product> getAllProducts(); // get all products

	public boolean save(Product product); // create product

	public boolean update(Product product); // update product

	public boolean delete(int id); // delete product by id

	public Product getProductByID(int id); // get() product by id

	public Product getProductByName(String name); // get() product by name

	public List<Product> viewByStatus(String status);
	
	public int changeStatus(int id);
}
