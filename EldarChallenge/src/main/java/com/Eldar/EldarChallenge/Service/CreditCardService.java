package com.Eldar.EldarChallenge.Service;

import com.Eldar.EldarChallenge.Entity.CreditCard;

import java.util.List;

public interface CreditCardService {

    public List<CreditCard> listAllCards();

    public CreditCard save(CreditCard creditCard);

    public void delete(CreditCard creditCard);

    public CreditCard findCreditCardById(Long creditCardId);

    public CreditCard findCreditCardByCardNumber(Long cardNumber);
}
