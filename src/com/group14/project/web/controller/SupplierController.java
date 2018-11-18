package com.group14.project.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group14.project.web.beans.Supplier;
import com.group14.project.web.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping(value="/addNewSupplier", method=RequestMethod.GET)
	public @ResponseBody String addNewSupplier(HttpServletRequest request) {
		String ajaxResponse = "";
		ObjectMapper mapper = new ObjectMapper();
		
		String supplierBrand = request.getParameter("supplierBrand");
		String supplierDescription = request.getParameter("supplierDescription");
		
		Supplier supplier = new Supplier(supplierBrand, supplierDescription);
		
		supplierService.addSupplier(supplier);
		
		try {
			ajaxResponse = mapper.writeValueAsString(Boolean.TRUE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ajaxResponse;
	}
}
