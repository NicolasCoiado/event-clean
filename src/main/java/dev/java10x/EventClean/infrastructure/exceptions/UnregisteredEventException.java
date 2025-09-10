package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnregisteredEventException extends RuntimeException {

    public UnregisteredEventException(String message) {
        super(message);
    }

}
