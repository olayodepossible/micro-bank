package com.possible.loanservice.model;

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
public class Loan extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private LoanType loanType;
    private Long totalLoan;
    private int duration;
    private int rate;
    private Long amountPaid;
    private Long outstandingAmount;
}
