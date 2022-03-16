package com.Eldar.EldarChallenge.Controllers;

import com.Eldar.EldarChallenge.DTO.Request.CreditCardRequest;
import com.Eldar.EldarChallenge.DTO.Request.OperationRequest;
import com.Eldar.EldarChallenge.DTO.Response.CreditCardResponse;
import com.Eldar.EldarChallenge.DTO.Response.OperationResponse;
import com.Eldar.EldarChallenge.Entity.Brand;
import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Entity.Operation;
import com.Eldar.EldarChallenge.Exceptions.EmptyListException;
import com.Eldar.EldarChallenge.Exceptions.ExceptionMessage;
import com.Eldar.EldarChallenge.Exceptions.NotFoundException;
import com.Eldar.EldarChallenge.Exceptions.NotValidException;
import com.Eldar.EldarChallenge.Service.BrandService;
import com.Eldar.EldarChallenge.Service.CreditCardService;
import com.Eldar.EldarChallenge.Service.OperationService;
import com.Eldar.EldarChallenge.Util.EntityDtoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController  //devuelve info en formato JSON
@Slf4j
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private EntityDtoConverter converter;


    @ApiOperation(value = "Search for all Operations", notes = "this method searches for all operations")
    @GetMapping(value = "card/allOp")
    public ResponseEntity<List<OperationResponse>> findAllOperations() {

        List<Operation> operations = operationService.listAllOperations();
        if (operations.isEmpty()) {
            throw new EmptyListException(ExceptionMessage.NO_CARDS.getValue());
        }

        return new ResponseEntity<>(converter.convertEntityToDto2(operations), HttpStatus.OK);
    }

    @ApiOperation(value = "Search for a specific Operation", notes = "this method returns a specific operation that a credit card has done using its Id number")
    @GetMapping(value = "card/Op/{idOperation}")
    public ResponseEntity<OperationResponse> findById(@PathVariable long idOperation) {
        try {
            Operation operation = operationService.findOperationById(idOperation);

            return new ResponseEntity<>(converter.convertEntityToDto(operation), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException(ExceptionMessage.OPERACION_NOT_FOUND.getValue());
        }
    }

    @ApiOperation(value = "Enter a new operation", notes = "this operation registers a new  operation  for an existing credit card")
    @PostMapping(value = "card/{idCard}/newOp")              //payload --> JSON
    public ResponseEntity<OperationResponse> newOperation(@PathVariable long idCard, @RequestBody OperationRequest payload) {

        try {
        CreditCard creditCard = creditCardService.findCreditCardById(idCard);

        Operation operation = new Operation(payload.getUsedFunds(), payload.getOperationDescription());

            operation.setCreditCard(creditCard);
            operation.setCardNumber(creditCard.getCardNumber());
            operation.setBrand(creditCard.getBrand().getBrandName());
            operation.setTax(creditCard.getBrand().getTax());
            operation.Validation();

            return new ResponseEntity<>(converter.convertEntityToDto(operationService.save(operation)), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }


}
