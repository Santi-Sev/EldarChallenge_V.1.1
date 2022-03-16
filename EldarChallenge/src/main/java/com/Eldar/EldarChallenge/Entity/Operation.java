package com.Eldar.EldarChallenge.Entity;

import com.Eldar.EldarChallenge.Exceptions.ExceptionMessage;
import com.Eldar.EldarChallenge.Exceptions.NotValidException;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "operation")
public class Operation {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operation")
    private Long idOperation;

    @Column(name = "Used_Funds")
    private float usedFunds;

    @Column(name = "Tax")
    private double tax;

    @Column(name = "Description")
    private String operationDescription;

    @Column(name = "Credit_Card")
    private long cardNumber;

    @Column(name = "Brand")
    private String brand;

    @ManyToOne()
    @JoinColumn(name = "id_card")
    private CreditCard creditCard;

    public Operation(){}

    public Operation(float usedFunds, String operationDescription){
        this.usedFunds = usedFunds;
        this.operationDescription = operationDescription;
        Validation();
    }

    public void Validation(){
        if(usedFunds > 1000 || usedFunds < 0){
          throw new NotValidException(ExceptionMessage.FUNDS_ERROR.getValue());
        }
    }

}


