package com.maha.firstspringproject;

import java.util.List;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/infybank")
public class CustomerAPI {
	
	@Autowired
	private CutomerService customerService;
	
	//@SuppressWarnings("rawtypes")
	@GetMapping(value = "/customers")
	public ResponseEntity getAllCustomers() throws InfyBankException
	{
		List<CustomerDTO> customerList = customerService.getAllCustomer();
		return new ResponseEntity(customerList, HttpStatus.OK);
	}
	@GetMapping(value = "/customers/{customerID}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws InfyBankException
	{
		CustomerDTO customerD = customerService.getCustomer(customerId);
		return new ResponseEntity<>(customerD,HttpStatus.OK);
		
	}
	

}
