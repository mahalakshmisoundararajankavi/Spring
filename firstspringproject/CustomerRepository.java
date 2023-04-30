package com.maha.firstspringproject;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers, Integer>
{

	//Iterable<Customers> findAll();

}
