package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.Supplier;

public interface SupplierService {

	public List<Supplier> getAllSuppliers();

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);

	public boolean delete(int id);

	public Supplier getSupplierById(int id);

}
