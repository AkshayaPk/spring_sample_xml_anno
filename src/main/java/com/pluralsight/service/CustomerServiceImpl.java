package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	/**
	 * Removed the hardcoded reference and applied the @Autowired annotation to do member injection
	 */
	//@Autowired
	private CustomerRepository customerRepository;
	/**
	 * We are going to use setter level injection now.
	 */
	/**
	 * We are going to see constructor level injection
	 * @param customerRepository
	 */
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
	System.out.println("Constructor level injection");
	this.customerRepository=customerRepository;
	}
	
	//@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Setter level injection");
		this.customerRepository = customerRepository;
	}

	/* (non-Javadoc)
	 * @see com.pluralsight.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
