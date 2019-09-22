package com.summerland.business;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.summerland.entities.Customer;
import com.summerland.repositories.CustomerRepository;
import com.summerland.repositories.OwnerRepository;

@Service
@Transactional
public class ImplBusinessCustomer implements IBusinessCustomer{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ArrayList<Customer> getCustomer() {
		return (ArrayList<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByEmail(String email){
		if(customerRepository.findCustomersByEmail(email).size()!=0){
			return (customerRepository.findCustomersByEmail(email)).get(0);
		}
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);

	}
}
