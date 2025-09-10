package dev.java10x.EventClean.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VenueNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleVenueNotFound (VenueNotFoundException exception) {

        Map<String, Object> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please enter another value.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UnregisteredEventException.class)
    public ResponseEntity<Map<String, Object>> handleUnregisteredEventException (UnregisteredEventException exception) {

        Map<String, Object> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please enter another value.");


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEventNotFoundException (EventNotFoundException exception){

        Map<String, Object> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please enter another value.");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
