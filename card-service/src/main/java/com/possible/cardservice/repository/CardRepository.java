package com.possible.cardservice.repository;

import com.possible.cardservice.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {
//    List<Card> findAccountsByCustomer(Long customerId );
}
