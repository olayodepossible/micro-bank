package com.possible.cardservice.model;

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
public class Card extends BaseEntity {
    private Long accountNumber;

    @Enumerated(EnumType.STRING)
    private CardType accountType;
    private String branchAddress;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Customer customer;
}
