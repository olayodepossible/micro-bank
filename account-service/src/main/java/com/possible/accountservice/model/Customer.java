package com.possible.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    private String fullName;
    private String email;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Accounts> accounts;



    public void addAccount(Accounts account){
        account.setCustomer(this);
        if (accounts == null){
            accounts = new ArrayList<>();
            accounts.add(account);
        }
        else {
            accounts.add(account);
        }

    }
}
