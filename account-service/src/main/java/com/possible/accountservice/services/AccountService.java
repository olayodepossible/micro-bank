package com.possible.accountservice.services;

import com.possible.accountservice.model.Accounts;

import java.util.List;

public interface AccountService {
    List<Accounts>  getAccountDetailsById(Long customerId);

    Accounts saveAccountDetailsByCustomer(Accounts accounts);
}
