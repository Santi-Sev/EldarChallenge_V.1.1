package com.Eldar.EldarChallenge.Service;

import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Entity.Operation;
import com.Eldar.EldarChallenge.Repository.CreditCardRepo;
import com.Eldar.EldarChallenge.Repository.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepo operationRepo;

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Operation> listAllOperations() {
        return (List<Operation>) operationRepo.findAll();
    }

    @Override
    @Transactional
    public Operation save(Operation operation) {
        return operationRepo.save(operation);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void delete(Operation operation) {
        operationRepo.delete(operation);
    }

    @Override
    @Transactional
    public Operation findOperationById(Long operationId) {
        return operationRepo.findById(operationId).orElse(null);
    }
}



