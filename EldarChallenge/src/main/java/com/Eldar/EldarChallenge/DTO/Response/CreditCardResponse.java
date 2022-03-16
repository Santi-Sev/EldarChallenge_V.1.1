package com.Eldar.EldarChallenge.DTO.Response;


import com.Eldar.EldarChallenge.Entity.Operation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Data
public class CreditCardResponse {

    private Long idCard;
    private String cardHolderName;
    private String cardHolderLastName;
    private long cardNumber;
    private BrandResponse brand;
    @JsonFormat(pattern ="MM-yy")
    private Date cardExpirationDate;

}
