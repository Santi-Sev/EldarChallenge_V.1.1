package com.Eldar.EldarChallenge.Service;

import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Entity.Operation;

import java.util.List;

public interface OperationService {

    public List<Operation> listAllOperations();

    public Operation save(Operation operation);

    public void delete(Operation operation);

    public Operation findOperationById(Long operationId);

}
