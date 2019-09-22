package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Customer;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

    List<Customer> findCustomersByEmail(String email);
}
