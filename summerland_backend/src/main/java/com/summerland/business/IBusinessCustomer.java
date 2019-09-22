package com.summerland.business;

import java.util.ArrayList;

import com.summerland.entities.Customer;

public interface IBusinessCustomer {

	ArrayList<Customer> getCustomer();

	Customer getCustomerByEmail(String email);

	void saveCustomer(Customer customer);
}
