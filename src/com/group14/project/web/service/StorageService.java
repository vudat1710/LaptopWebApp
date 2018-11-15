package com.group14.project.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group14.project.web.dao.StorageDao;

@Service("storageService")
public class StorageService {
	@Autowired
	private StorageDao storageDao;
	
	public int countNoBookCanAddByProductId(String productId) {
		return storageDao.countNoProductByProductId(productId);
	}
}
