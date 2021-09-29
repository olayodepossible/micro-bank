package com.possible.cardservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer  {
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Card> accounts;



//    public void addAccount(Card account){
//        account.setCustomer(this);
//        if (accounts == null){
//            accounts = new ArrayList<>();
//            accounts.add(account);
//        }
//        else {
//            accounts.add(account);
//        }
//
//    }
}
