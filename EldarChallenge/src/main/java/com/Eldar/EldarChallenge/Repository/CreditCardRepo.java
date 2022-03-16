package com.Eldar.EldarChallenge.Repository;

import com.Eldar.EldarChallenge.Entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {

    public CreditCard findOneByCardNumber(long cardNumber);
}
