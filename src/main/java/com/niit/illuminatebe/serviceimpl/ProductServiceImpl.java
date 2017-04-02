package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.ProductDao;
import com.niit.illuminatebe.model.Product;
import com.niit.illuminatebe.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return productDao.update(product);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}

	@Override
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductByID(id);
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return productDao.getProductByName(name);
	}

	@Override
	public List<Product> viewByStatus(String status) {
		// TODO Auto-generated method stub
		return productDao.viewByStatus(status);
	}

	@Override
	public int changeStatus(int id) {
		// TODO Auto-generated method stub
		return productDao.changeStatus(id);
	}

}
