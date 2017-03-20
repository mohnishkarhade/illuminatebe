package com.niit.illuminatebe.dao;

import java.util.List;

import com.niit.illuminatebe.model.Category;

public interface CategoryDao {
	public List<Category> getAllCategories();

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(int id);

	public Category getCategoryById(int id);
}
