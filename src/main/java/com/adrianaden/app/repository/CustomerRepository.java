package com.adrianaden.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrianaden.app.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findAll();
	List<Customer> findByLastName(String lastName);
}
