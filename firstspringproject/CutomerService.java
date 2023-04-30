package com.maha.firstspringproject;

import java.util.List;

public interface CutomerService {
	
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
	
	public List<CustomerDTO> getAllCustomer()throws InfyBankException;

}
