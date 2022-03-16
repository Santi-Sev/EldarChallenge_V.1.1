package com.Eldar.EldarChallenge.Entity;

import com.Eldar.EldarChallenge.Exceptions.ExceptionMessage;
import com.Eldar.EldarChallenge.Exceptions.NotFoundException;
import com.Eldar.EldarChallenge.Exceptions.NotValidException;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private long idBrand;

    @Column(name = "Brand_Name")
    private String brandName;

    @Column(name = "tax")
    private double tax;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditCard> creditCards;

    public Brand(String brandName) {
        this.brandName = brandName;
        taxValue();
        if (tax > 5) {
            tax = 5;
        }
        if (tax < 0.3) {
            tax = 0.3;
        }
    }

    public Brand() {

    }

    public void BrandValidation(){
        if(brandName != "VISA" ||brandName != "AMEX" || brandName != "NARA"){
            throw new NotValidException(ExceptionMessage.BRAND_NOT_FOUND.getValue());
        }
    }

    public void taxValue() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY");
        switch (brandName) {
            case "VISA":
                this.tax = Integer.parseInt(dtf.format(LocalDate.now())) / LocalDate.now().getMonthValue();
                break;
            case "NARA":
                this.tax = LocalDate.now().getDayOfMonth() * 0.5;
                break;
            case "AMEX":
                this.tax = LocalDate.now().getMonthValue() * 0.1;
                break;
        }
    }
}
