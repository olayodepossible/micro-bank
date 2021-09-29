package com.possible.accountservice.services;


import com.possible.accountservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    Customer findCustomer(Long id);

    Customer saveCustomer(Customer customer);
}
