package com.pepsin.dpms_patient_service.controller;


import com.pepsin.dpms_patient_service.DTO.PatientRequestDTO;
import com.pepsin.dpms_patient_service.DTO.PatientResponseDTO;
import com.pepsin.dpms_patient_service.DTO.PatientUpdateDTO;
import com.pepsin.dpms_patient_service.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This is our "Hospital Receptionist".
 * It's the entry point for people outside our Patient Service to talk to it.
 * It receives requests, talks to the Hospital Manager (PatientService),
 * and sends back responses.
 *
 * @RestController: This sticker tells Spring that this class handles web requests
 * and automatically converts Java objects into JSON (and vice-versa).
 * @RequestMapping("/api/patients"): This means all the "phone numbers" (URLs) for this
 * receptionist will start with "/api/patients".
 * @RequiredArgsConstructor (from Lombok): Automatically injects the PatientService.
 */
@RestController
@RequestMapping("/api/patients")
 // Automatically creates a constructor for final fields
public class PatientController {

    // Our "Hospital Manager" (PatientService) that the Receptionist talks to.
    private PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Handles requests to create a new patient.
     * HTTP Method: POST
     * URL: /api/patients
     *
     * @param patientRequestDTO The "New Patient Registration Form" sent by the client.
     * @Valid: This tells Spring to check the rules on the form (DTO)
     * before even letting the Manager see it.
     * @return A response with the "Patient Summary Form" and a "201 Created" status.
     */
    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO createdPatient = patientService.createPatient(patientRequestDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    /**
     * Handles requests to get a patient's information by ID.
     * HTTP Method: GET
     * URL: /api/patients/{id} (e.g., /api/patients/123e4567-e89b-12d3-a456-426614174000)
     *
     * @param id The unique ID of the patient, taken from the URL path.
     * @PathVariable: Tells Spring to get the ID from the URL.
     * @return A response with the "Patient Summary Form" and a "200 OK" status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable UUID id) {
        PatientResponseDTO patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient); // Shorthand for new ResponseEntity<>(patient, HttpStatus.OK)
    }

    /**
     * Handles requests to get all patients' information.
     * HTTP Method: GET
     * URL: /api/patients
     *
     * @return A response with a list of "Patient Summary Forms" and a "200 OK" status.
     */
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    /**
     * Handles requests to update an existing patient's information.
     * HTTP Method: PUT
     * URL: /api/patients/{id}
     *
     * @param id The unique ID of the patient to update.
     * @param patientUpdateDTO The "Update Patient Information Form" with new details.
     * @return A response with the updated "Patient Summary Form" and a "200 OK" status.
     */
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
                                                            @RequestBody PatientUpdateDTO patientUpdateDTO) {
        PatientResponseDTO updatedPatient = patientService.updatePatient(id, patientUpdateDTO);
        return ResponseEntity.ok(updatedPatient);
    }

    /**
     * Handles requests to delete a patient.
     * HTTP Method: DELETE
     * URL: /api/patients/{id}
     *
     * @param id The unique ID of the patient to delete.
     * @return A response with no content and a "204 No Content" status (meaning success, but nothing to send back).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
