package com.Eldar.EldarChallenge.Entity;

import com.Eldar.EldarChallenge.Exceptions.ExceptionMessage;
import com.Eldar.EldarChallenge.Exceptions.NotValidException;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Class representing an existing Credit Card")
@Data
@Entity
@Table(name = "creditCard")
public class CreditCard {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private Long idCard;

    @Column(name = "CardHolder_Name")
    private String cardHolderName;

    @Column(name = "CardHolder_LastName")
    private String cardHolderLastName;

    @Column(name = "Card_Number")
    private long cardNumber;


    @Column(name = "Exp_Date")
    @JsonFormat(pattern ="MM-yy")
    private Date cardExpirationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Operation> Operations;

    public CreditCard(){}

    public void cardValidation(){

        LocalDate ExpDate = cardExpirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if(LocalDate.now().isAfter(ExpDate)){
            throw new NotValidException(ExceptionMessage.CARD_EXPIRED.getValue());
        }

    }

}
