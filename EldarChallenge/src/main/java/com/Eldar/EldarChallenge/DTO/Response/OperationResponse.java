package com.Eldar.EldarChallenge.DTO.Response;

import lombok.Data;

@Data
public class OperationResponse {

    private Long idOperation;
    private long cardNumber;
    private String brand;
    private float usedFunds;
    private double tax;
    private String operationDescription;
    private String  operationStatus;

}
