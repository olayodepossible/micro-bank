package com.possible.accountservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {
    private Long accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.SAVINGS;
    private String branchAddress;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
