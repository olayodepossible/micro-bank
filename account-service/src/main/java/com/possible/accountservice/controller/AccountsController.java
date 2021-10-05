package com.possible.accountservice.controller;

import com.possible.accountservice.model.Accounts;
import com.possible.accountservice.model.Customer;
import com.possible.accountservice.services.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountsController {

    private final AccountService accountService;

    @GetMapping("/customer/{id}")
//    @CircuitBreaker(name = "detailsForCustomerSupportApp")
    public ResponseEntity<List<Accounts>> getAccountDetails(@PathVariable Long id){
        List<Accounts> accounts = accountService.getAccountDetailsById(id);
        if (accounts.size() > 0){
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity createAccount(@RequestBody Accounts accounts){
            return new ResponseEntity(accountService.saveAccountDetailsByCustomer(accounts), HttpStatus.OK);

    }
}
