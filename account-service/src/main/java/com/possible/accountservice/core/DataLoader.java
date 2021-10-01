package com.possible.accountservice.core;

import com.possible.accountservice.config.AccountServiceConfig;
import com.possible.accountservice.model.AccountType;
import com.possible.accountservice.model.Accounts;
import com.possible.accountservice.model.Customer;
import com.possible.accountservice.model.Gender;
import com.possible.accountservice.repository.CustomerRepository;
import com.possible.accountservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final CustomerRepository customerRepository;
    private final AccountService accountService;


    private final AccountServiceConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Message from config server >>>> {}", config.getMsg());
        String [] firstNames = {"Roy %s ", "%s jackson", "Michael %s", "David %s"};
        String [] lastNames = {"Homey", "Janet ", "Owen", "Smith"};
        String [] addresses1 = {"123, Homey %s", "4, Johnson %s", "%s 12, Owen", "565, Smith %s"};
        String [] addresses2 = {"City", "Road", "Crescent", "Town"};
        String [] genders = {"MALE", "FEMALE"};
        String [] accountTypes = {"SAVINGS", "CURRENT","LOAN"};

        List<Customer> customers = new ArrayList<>();
        IntStream.range(0, 20)
                .forEach(i ->{
                    String firstName = firstNames[i % firstNames.length];
                    String lastName = lastNames[i % lastNames.length];
                    String address1 = addresses1[i % addresses1.length];
                    String address2 = addresses2[i % addresses2.length];
                    String fullName = String.format(lastName, firstName);
                    String customerAddress = String.format(address1, address2);

                    Accounts account = Accounts.builder()
                            .accountNumber((new Random().nextLong() % 100000000000000L) + + 520000000000000L)
                            .accountType(AccountType.valueOf(accountTypes[i%accountTypes.length]))
                            .branchAddress(customerAddress)
                            .build();

                    Customer customerToSave = Customer.builder()
                            .fullName(fullName)
                            .address(customerAddress)
                            .email(fullName+"@gmail.com")
                            .gender(Gender.valueOf(genders[i%genders.length]))
                            .phoneNumber("+"+i+"0-01239056"+i)
                            .build();

                    customerToSave.addAccount(account);
                    customers.add(customerToSave);
                });

        customerRepository.saveAll(customers);

    }
}
