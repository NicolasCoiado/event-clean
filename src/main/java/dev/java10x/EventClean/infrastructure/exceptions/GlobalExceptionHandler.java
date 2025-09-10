package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VenueNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleVenueNotFound(VenueNotFoundException exception) {

        Map<String, Object> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please enter another value.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EventNotFound.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFound(EventNotFound exception) {

        Map<String, Object> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please enter another value.");


        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
