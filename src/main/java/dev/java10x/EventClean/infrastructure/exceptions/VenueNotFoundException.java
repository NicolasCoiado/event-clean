package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VenueNotFoundException extends RuntimeException {

    public VenueNotFoundException(String message){
        super(message);
    }

}
