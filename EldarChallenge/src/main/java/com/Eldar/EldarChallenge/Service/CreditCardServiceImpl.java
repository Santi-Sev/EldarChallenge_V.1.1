package com.Eldar.EldarChallenge.Service;

import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepo creditCardRepo;

    @Override
    @Transactional
    public List<CreditCard> listAllCards() { //returns a list of all credit Cards
        return (List<CreditCard>) creditCardRepo.findAll();
    }

    @Override
    @Transactional
    public CreditCard save(CreditCard creditCard) { //saves credit card in an active DB
        return creditCardRepo.save(creditCard);
    }

    @Override
    @Transactional
    public void delete(CreditCard creditCard) {
        creditCardRepo.delete(creditCard); //saves credit card in an active DB
    }

    @Override
    @Transactional
    public CreditCard findCreditCardById(Long creditCardId) { //searches for a credit card with its designated id
        return creditCardRepo.findById(creditCardId).orElse(null);
    }

    @Override
    public CreditCard findCreditCardByCardNumber(Long cardNumber) {
        return creditCardRepo.findOneByCardNumber(cardNumber);
    }
}
