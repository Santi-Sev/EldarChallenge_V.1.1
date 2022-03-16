package com.Eldar.EldarChallenge.Util;


import com.Eldar.EldarChallenge.DTO.Request.BrandRequest;
import com.Eldar.EldarChallenge.DTO.Request.CreditCardRequest;
import com.Eldar.EldarChallenge.DTO.Request.OperationRequest;
import com.Eldar.EldarChallenge.DTO.Response.BrandResponse;
import com.Eldar.EldarChallenge.DTO.Response.CreditCardResponse;
import com.Eldar.EldarChallenge.DTO.Response.OperationResponse;
import com.Eldar.EldarChallenge.Entity.Brand;
import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Entity.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    // CREDIT CARD CONVERTERS
    public CreditCardResponse convertEntityToDto(CreditCard creditCard){
        return modelMapper.map(creditCard, CreditCardResponse.class);
    }

    public CreditCard convertDtoToEntity(CreditCardRequest creditCardRequest){
        return modelMapper.map(creditCardRequest, CreditCard.class);
    }

    public List<CreditCardResponse> convertEntityToDto(List<CreditCard> creditCards){
        return creditCards.stream()
                .map(creditCard -> convertEntityToDto(creditCard))
                .collect(Collectors.toList());
    }

    // BRAND CONVERTERS
    public BrandResponse convertEntityToDto(Brand brand){
        return modelMapper.map(brand, BrandResponse.class);
    }

    public Brand convertDtoToEntity(BrandRequest brandRequest){
        return modelMapper.map(brandRequest, Brand.class);
    }

    //OPERATION CONVERTERS
    public OperationResponse convertEntityToDto(Operation operation){
        return modelMapper.map(operation, OperationResponse.class);
    }

    public Operation convertDtoToEntity(OperationRequest operationRequest){
        return modelMapper.map(operationRequest, Operation.class);
    }

    public List<OperationResponse> convertEntityToDto2(List<Operation> operations){
        return operations.stream()
                .map(operation -> convertEntityToDto(operation))
                .collect(Collectors.toList());
    }

}
