package com.possible.cardservice.controller;

import com.possible.cardservice.model.Card;
import com.possible.cardservice.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/accounts")
public class CardController {

    private final CardService cardService;

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Card>> getAccountDetails(@PathVariable Long id){
        List<Card> accounts = cardService.getCardDetailsById(id);
        if (accounts.size() > 0){
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity createAccount(@RequestBody Card card){
            return new ResponseEntity(cardService.saveCardDetailsByCustomer(card), HttpStatus.OK);

    }
}
