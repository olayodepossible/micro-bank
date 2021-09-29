package com.possible.loanservice.repository;

import com.possible.loanservice.model.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long> {
//    List<Loan> findLoanByCustomer(Long customerId );
}
