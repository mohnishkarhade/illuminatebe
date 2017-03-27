package com.niit.illuminatebe.dao;

import java.util.List;

import com.niit.illuminatebe.model.Supplier;

public interface SupplierDao {
	public List<Supplier> getAllSuppliers();

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(int id);

	public Supplier getSupplierById(int id);
}
