package com.possible.cardservice.services;

import com.possible.cardservice.model.Card;
import com.possible.cardservice.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public List<Card> getCardDetailsById(Long customerId) {

//        return cardRepository.findAccountsByCustomer(customerId);
        return null;
    }

    @Override
    public Card saveCardDetailsByCustomer(Card card) {
        return cardRepository.save(card);
    }

}
