package com.pepsin.dpms_patient_service.service;



import com.pepsin.dpms_patient_service.DTO.PatientRequestDTO;
import com.pepsin.dpms_patient_service.DTO.PatientResponseDTO;
import com.pepsin.dpms_patient_service.DTO.PatientUpdateDTO;

import java.util.List;
import java.util.UUID;

/**
 * This is the "list of promises" our Hospital Manager (Patient Service) makes.
 * It defines what operations related to patients can be performed.
 * It's like a menu of services the Hospital offers for patients.
 */
public interface PatientService {

    /**
     * Creates a new patient record.
     * @param patientRequestDTO The form filled by the new patient.
     * @return The summary form of the created patient.
     */
    PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);

    /**
     * Retrieves a patient's summary form by their unique ID.
     * @param id The unique ID of the patient.
     * @return The patient's summary form.
     */
    PatientResponseDTO getPatientById(UUID id);

    /**
     * Retrieves all patient summary forms.
     * @return A list of all patient summary forms.
     */
    List<PatientResponseDTO> getAllPatients();

    /**
     * Updates an existing patient's information.
     * @param id The unique ID of the patient to update.
     * @param patientUpdateDTO The form with updated patient details.
     * @return The updated patient's summary form.
     */
    PatientResponseDTO updatePatient(UUID id, PatientUpdateDTO patientUpdateDTO);

    /**
     * Deletes a patient record by their unique ID.
     * @param id The unique ID of the patient to delete.
     */
    void deletePatient(UUID id);
}
