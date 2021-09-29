package com.possible.loanservice.services;

import com.possible.loanservice.model.Loan;
import com.possible.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    @Override
    public List<Loan> getLoanDetailsById(Long customerId) {

//        return loanRepository.findLoanByCustomer(customerId);
        return null;

    }

    @Override
    public Loan saveLoanDetailsByCustomer(Loan loan) {
        return loanRepository.save(loan);
    }

}
