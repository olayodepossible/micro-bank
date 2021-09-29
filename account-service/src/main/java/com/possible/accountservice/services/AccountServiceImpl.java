package com.possible.accountservice.services;

import com.possible.accountservice.model.Accounts;
import com.possible.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    public List<Accounts> getAccountDetailsById(Long customerId) {

        return accountRepository.findAccountsByCustomer(customerId);

    }

    @Override
    public Accounts saveAccountDetailsByCustomer(Accounts accounts) {
        return accountRepository.save(accounts);
    }

}
