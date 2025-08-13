package com.pepsin.dpms_doctor_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This is our special "Couldn't Find It!" problem note.
 * We use this when someone asks for something (like a patient) that doesn't exist.
 *
 * @ResponseStatus(HttpStatus.NOT_FOUND): This sticker tells Spring:
 * "If this problem happens, tell the person asking
 * that the thing they asked for was 'Not Found' (HTTP 404 error)."
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // When this exception is thrown, send a 404 Not Found status
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message); // Pass the message (e.g., "Patient not found with id: ...") to the parent
    }
}