package com.maha.firstspringproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service(value="CustomerService")
@Transactional
public class CustomerServiceImpl implements CutomerService
{
	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException {
		// TODO Auto-generated method stub
		Optional<Customers> opt = customerRepository.findById(customerId);
		Customers customers = opt.orElseThrow(()-> new InfyBankException("Service.CUSTOMERS_NOT_FOUND"));
		CustomerDTO customer2 = new CustomerDTO();
		customer2.setCustomerId(customers.getCustomerId());
		customer2.setDateofBirth(customers.getDateofBirth());
		customer2.setEmailId(customers.getEmailId());
		customer2.setName(customers.getName());
		return customer2;
	}

	@Override
	public List<CustomerDTO> getAllCustomer() throws InfyBankException {
		// TODO Auto-generated method stub
		Iterable<Customers> customer = customerRepository.findAll();
		List<CustomerDTO> customer2 = new ArrayList<>();
		//Lambda expression
		customer.forEach(cust -> { CustomerDTO cus = new CustomerDTO();
				cus.setCustomerId(cust.getCustomerId());
		        cus.setDateofBirth(cust.getDateofBirth());
		        cus.setEmailId(cust.getEmailId());
		        cus.setName(cust.getName());
		        customer2.add(cus);  
		});
		if(customer2.isEmpty()) throw new InfyBankException("Service.CUSTOMERS_NOT_FOUND");
		return customer2;
	}

}
