package com.Eldar.EldarChallenge.DTO.Response;

import com.Eldar.EldarChallenge.Entity.Brand;
import com.Eldar.EldarChallenge.Entity.CreditCard;
import lombok.Data;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
public class BrandResponse{

    private String brandName;
    private double tax;

}
