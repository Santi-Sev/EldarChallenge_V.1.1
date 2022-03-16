package com.Eldar.EldarChallenge.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotValidException extends RuntimeException {

    public NotValidException(String mensaje){super(mensaje);}
}
