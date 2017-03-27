package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.Category;

public interface CategoryService {

	public List<Category> getAllCategories();

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(int id);

	public Category getCategoryById(int id);
}
