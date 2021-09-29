package com.possible.cardservice.services;

import com.possible.cardservice.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getCardDetailsById(Long customerId);

    Card saveCardDetailsByCustomer(Card card);
}
