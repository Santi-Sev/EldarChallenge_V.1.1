package com.Eldar.EldarChallenge.DTO.Request;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Data
@ApiModel(description = "this class represents a new card being entered")
public class CreditCardRequest {

    @NotNull
    @NotEmpty
    @ApiModelProperty(notes = "card owner first name", example = "SANTIAGO", required = true)
    private String cardHolderName;

    @ApiModelProperty(notes = "card owner last name", example = "SEV", required = true)
    private String cardHolderLastName;

    @ApiModelProperty(notes = "credit card number", example = "5555555555554444", required = true)
    private long cardNumber;

    private BrandRequest brand;

    @ApiModelProperty(notes = "expiration date",example = "12-23", required = true)
    @JsonFormat(pattern ="MM-yy") //date format: month(MM) - year(yy)
    private Date cardExpirationDate;

}
