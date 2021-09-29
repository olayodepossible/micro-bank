package com.possible.accountservice.repository;

import com.possible.accountservice.model.Accounts;
import com.possible.accountservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Accounts, Long> {
    List<Accounts> findAccountsByCustomer(Long customerId );
}
