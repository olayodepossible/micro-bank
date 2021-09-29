package com.possible.loanservice.services;

import com.possible.loanservice.model.Loan;

import java.util.List;

public interface LoanService {
    List<Loan>  getLoanDetailsById(Long customerId);

    Loan saveLoanDetailsByCustomer(Loan loan);
}
