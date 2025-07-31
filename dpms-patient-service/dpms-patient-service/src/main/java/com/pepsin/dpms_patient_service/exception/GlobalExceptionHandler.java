package com.pepsin.dpms_patient_service.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * This is our "Hospital Problem Solver" who catches all kinds of problems
 * and gives a nice, polite response back.
 *
 * @RestControllerAdvice: This sticker tells Spring:
 * "This class is special! It listens for problems (exceptions)
 * that happen anywhere in our web controllers and handles them."
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method catches our "Couldn't Find It!" problem (ResourceNotFoundException).
     * It builds a friendly message to send back, saying what went wrong and when.
     *
     * @param ex The ResourceNotFoundException that was thrown.
     * @return A nice response with an error message and a 404 Not Found status.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                "NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * This method catches problems when someone fills out a form incorrectly (validation errors).
     * For example, if they leave a required field empty or put a bad email address.
     * It collects all the errors and sends them back in a clear way.
     *
     * @param ex The MethodArgumentNotValidException (thrown when validation fails).
     * @return A nice response with all the validation errors and a 400 Bad Request status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method catches any OTHER problems that we didn't specifically plan for.
     * It's like the "catch-all" problem solver.
     * It sends back a general error message and a 500 Internal Server Error status.
     *
     * @param ex The general Exception that was thrown.
     * @return A general error response with a 500 Internal Server Error status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                "INTERNAL_SERVER_ERROR"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * A simple class to structure our error messages nicely.
     */
    public record ErrorDetails(LocalDateTime timestamp, String message, String details) {}
}
