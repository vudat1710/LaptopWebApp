package com.group14.project.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.beans.Supplier;
import com.group14.project.web.dao.SupplierDao;

@Service("supplierService")
public class SupplierService {
	@Autowired
	private SupplierDao supplierDao;

	public List<Supplier> getAllSuppliers() {
		return supplierDao.getAllSuppliers();
	}
}
