package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.SupplierDao;
import com.niit.illuminatebe.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	private final Logger logger = LoggerFactory.getLogger(SupplierDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Supplier> getAllSuppliers() {
		logger.info("Starting getAllSuppliers method");
		try {
			List<Supplier> supplierList = sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			for (Supplier c : supplierList) {
				logger.info("Supplier List:: " + c);
			}
			logger.info("Ending getAllSuppliers method");
			return supplierList;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean save(Supplier supplier) {
		logger.info("Starting save supplier method");
		try {
			logger.info("Saving supplier...");
			sessionFactory.getCurrentSession().save(supplier);
			logger.info("Supplier details saved successfully.");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Fails saving supplier.");
			return false;
		}
	}

	@Override
	public boolean update(Supplier supplier) {
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplier getSupplierById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
