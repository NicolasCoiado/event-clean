package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UnregisteredVenueException extends RuntimeException {
    public UnregisteredVenueException(String message) {
        super(message);
    }
}
