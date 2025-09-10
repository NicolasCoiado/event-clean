package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventNotFound extends RuntimeException {

    public EventNotFound(String message) {
        super(message);
    }

}
