package com.possible.loanservice.controller;

import com.possible.loanservice.model.Loan;
import com.possible.loanservice.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class LoanController {

    private final LoanService loanService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Loan>> getAccountDetails(@PathVariable Long id){
        List<Loan> accounts = loanService.getLoanDetailsById(id);
        if (accounts.size() > 0){
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Loan> createAccount(@RequestBody Loan loan){
            return new ResponseEntity<>(loanService.saveLoanDetailsByCustomer(loan), HttpStatus.OK);

    }
}
