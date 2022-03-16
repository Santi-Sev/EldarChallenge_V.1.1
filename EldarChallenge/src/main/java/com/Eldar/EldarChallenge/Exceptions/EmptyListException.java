package com.Eldar.EldarChallenge.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmptyListException extends RuntimeException {

    public EmptyListException(String mensaje){super(mensaje);}
}
