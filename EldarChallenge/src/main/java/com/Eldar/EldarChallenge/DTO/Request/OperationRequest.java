package com.Eldar.EldarChallenge.DTO.Request;

import com.Eldar.EldarChallenge.Entity.CreditCard;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class OperationRequest {

    @ApiModelProperty(notes = "funds used", example = "900", required = true)
    private float usedFunds;
    @ApiModelProperty(notes = "a small description for why you realized a transaction", example = "McDonalds Combo", required = true)
    private String operationDescription;

}
