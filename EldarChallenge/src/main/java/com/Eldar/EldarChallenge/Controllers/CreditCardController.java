package com.Eldar.EldarChallenge.Controllers;

import com.Eldar.EldarChallenge.DTO.Request.CreditCardRequest;
import com.Eldar.EldarChallenge.DTO.Response.CreditCardResponse;
import com.Eldar.EldarChallenge.Entity.Brand;
import com.Eldar.EldarChallenge.Entity.CreditCard;
import com.Eldar.EldarChallenge.Exceptions.EmptyListException;
import com.Eldar.EldarChallenge.Exceptions.NotFoundException;
import com.Eldar.EldarChallenge.Exceptions.NotValidException;
import com.Eldar.EldarChallenge.Exceptions.ExceptionMessage;
import com.Eldar.EldarChallenge.Service.BrandService;
import com.Eldar.EldarChallenge.Service.CreditCardService;
import com.Eldar.EldarChallenge.Service.OperationService;
import com.Eldar.EldarChallenge.Util.EntityDtoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController  //returns info in JSON format
@Slf4j
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private EntityDtoConverter converter;

    @ApiOperation(value = "Retrieve all existing credit cards", notes = "this operation returns all stored credit cards")
    @GetMapping(value = "card")
    public ResponseEntity<List<CreditCardResponse>> findAllCreditCards() {

        List<CreditCard> creditCards = creditCardService.listAllCards();
        if (creditCards.isEmpty()) {
            throw new EmptyListException(ExceptionMessage.NO_CARDS.getValue());
        }

        return new ResponseEntity<>(converter.convertEntityToDto(creditCards), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve a specific credit card", notes = "this operation returns a specific credit card using the credit card's ID")
    @GetMapping(value = "card/{idCard}")
    public ResponseEntity<CreditCardResponse> findById(@PathVariable long idCard) {
        try {
            CreditCard creditCard = creditCardService.findCreditCardById(idCard);

            return new ResponseEntity<>(converter.convertEntityToDto(creditCard), HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException(ExceptionMessage.CARD_NOT_FOUND.getValue());
        }
    }

    @ApiOperation(value = "Enter a new credit card", notes = "this operation registers a new credit card")
    @PostMapping(value = "card/New")              //payload --> JSON
    public ResponseEntity<CreditCardResponse> newCard(@RequestBody CreditCardRequest payload) {

        try {
            CreditCard creditCard = converter.convertDtoToEntity(payload);
            if (creditCardService.findCreditCardByCardNumber(creditCard.getCardNumber()) != null){
                throw new NotValidException(ExceptionMessage.CARD_ALREADY_EXITS.getValue());
            }
            creditCard.cardValidation(); //check if card is expired

            Brand brand = new Brand(payload.getBrand().getBrandName());
            brand.BrandValidation(); //check if the brand selected is OK
            brand.taxValue(); //sets the tax that depends on the brand

            brandService.save(brand); //save brand if no exceptions have occurred
            creditCard.setBrand(brand); //set brand to card
            creditCardService.save(creditCard);

            return new ResponseEntity<>(converter.convertEntityToDto(creditCard), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}

// try {
//
//         Brand brand = brandService.save(new Brand(payload.getBrand().getBrandName()));
//         CreditCard creditCard = converter.convertDtoToEntity(payload); //ENT
//         creditCard.setBrand(brand);
//
//         if (creditCardService.findCreditCardByCardNumber(creditCard.getCardNumber()) == null) {
//         creditCard.cardValidation();
//         creditCardService.save(creditCard);
//         } else {
//         creditCard.setCardHolderName("ERROR, THIS CARD IS ALREADY IN THE DATABASE");
//         creditCard.setCardHolderLastName("CARD NOT SAVED, PLEASE TRY AGAIN WITH ANOTHER CARD NUMBER");
//         creditCard.setStatus("INVALID");
//         System.out.println("UNABLE TO SAVE THIS CARD, SINCE IT ALREADY EXITS IN THE DATABASE");
//         }
//         return new ResponseEntity<>(converter.convertEntityToDto(creditCard), HttpStatus.OK);
//        }
//        catch (Exception e){
//        throw new NotValidException(ExceptionMessage.CARD_NOT_VALID.getValue());
//        }