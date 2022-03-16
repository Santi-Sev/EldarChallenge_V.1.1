package com.Eldar.EldarChallenge.DTO.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "this class represents the credit card brand entered, and then it calculates its tax rate")
public class BrandRequest {

    @ApiModelProperty(notes = "credit card brand", example = "VISA", required = true)
    private String brandName;

}
