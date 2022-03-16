package com.Eldar.EldarChallenge.Repository;

import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operation, Long> {


}
