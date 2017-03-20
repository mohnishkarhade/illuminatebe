package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.CategoryDao;
import com.niit.illuminatebe.model.Category;
import com.niit.illuminatebe.service.CategoryService;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getAllCategories();
	}

	public boolean save(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.save(category);
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.update(category);
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return categoryDao.delete(id);
	}

	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(id);
	}

}
