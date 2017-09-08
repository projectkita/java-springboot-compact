package com.adrianaden.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianaden.app.model.Customer;
import com.adrianaden.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
