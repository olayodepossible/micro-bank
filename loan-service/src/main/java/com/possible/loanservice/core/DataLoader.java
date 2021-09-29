package com.possible.loanservice.core;


import com.possible.loanservice.model.Customer;
import com.possible.loanservice.model.Gender;
import com.possible.loanservice.model.Loan;
import com.possible.loanservice.model.LoanType;
import com.possible.loanservice.repository.LoanRepository;
import com.possible.loanservice.services.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final LoanRepository loanRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String [] firstNames = {"Roy %s ", "%s jackson", "Michael %s", "David %s"};
        String [] lastNames = {"Homey", "Janet ", "Owen", "Smith"};
        String [] addresses1 = {"123, Homey %s", "4, Johnson %s", "%s 12, Owen", "565, Smith %s"};
        String [] addresses2 = {"City", "Road", "Crescent", "Town"};
        String [] genders = {"MALE", "FEMALE"};
        String [] loanType = {"CAR", "RENT","BUSINESS", "PERSONAL"};

        List<Loan> loanList = new ArrayList<>();
        IntStream.range(0, 20)
                .forEach(i ->{
                    String firstName = firstNames[i % firstNames.length];
                    String lastName = lastNames[i % lastNames.length];
                    String address1 = addresses1[i % addresses1.length];
                    String address2 = addresses2[i % addresses2.length];
                    String fullName = String.format(lastName, firstName);
                    String customerAddress = String.format(address1, address2);

                    Customer customerToSave = Customer.builder()
                            .fullName(fullName)
                            .address(customerAddress)
                            .email(fullName+"@gmail.com")
                            .gender(Gender.valueOf(genders[i%genders.length]))
                            .phoneNumber("+"+i+"0-01239056"+i)
                            .build();

                    Loan loanToSave = Loan.builder()
                            .loanType(LoanType.valueOf(loanType[i%loanType.length]))
                            .totalLoan(new Random().nextLong() % 10000L)
                            .duration(i % 10)
                            .amountPaid(0L)
                            .outstandingAmount(0L)
                            .build();

                    loanList.add(loanToSave);
                });

        loanRepository.saveAll(loanList);

    }
}
