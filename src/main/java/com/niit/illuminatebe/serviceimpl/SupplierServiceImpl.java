package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.SupplierDao;
import com.niit.illuminatebe.model.Supplier;
import com.niit.illuminatebe.service.SupplierService;

@Service("supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierDao.getAllSuppliers();
	}

	@Override
	public boolean save(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.save(supplier);
	}

	@Override
	public boolean update(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.update(supplier);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return supplierDao.delete(id);
	}

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierById(id);
	}

}
