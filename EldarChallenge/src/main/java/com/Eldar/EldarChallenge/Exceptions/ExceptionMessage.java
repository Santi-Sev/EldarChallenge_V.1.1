package com.Eldar.EldarChallenge.Exceptions;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    CARD_NOT_FOUND("Sorry! the credit card you entered doesn't exist :( "),
    OPERACION_NOT_FOUND("Sorry! the operation you entered doesn't exist :( "),

    NO_CARDS("There aren't any registered Credit Cards in the Data Base!"),
    NO_OPERATIONS("There aren't any registered Operations in the Data Base!"),

    INVALID_ACTION("Sorry!, there seems to be problem with the values you entered, please check to see if everything is OK"),

    CARD_ALREADY_EXITS("Sorry, this card already exists!"),
    CARD_EXPIRED("Sorry, this card is EXPIRED --> CARD NOT SAVED"),
    FUNDS_ERROR("Please Enter a value between 0$ and 1000$"),
    BRAND_NOT_FOUND("For now we only work for VISA, AMEX & NARA, in the future we will integrate other brands but for now you're stuck with this ;)");
    ExceptionMessage(String message){value = message;}

    private final String value;
}
