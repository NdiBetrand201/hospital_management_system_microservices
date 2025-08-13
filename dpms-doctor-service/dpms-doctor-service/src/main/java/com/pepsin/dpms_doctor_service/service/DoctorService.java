package com.pepsin.dpms_doctor_service.service;


import com.pepsin.dpms_doctor_service.DTO.DoctorRequestDTO;
import com.pepsin.dpms_doctor_service.DTO.DoctorResponseDTO;
import com.pepsin.dpms_doctor_service.DTO.DoctorUpdateDTO;

import java.util.List;
import java.util.UUID;

/**
 * This is the "list of promises" our Doctor's Office Manager (Doctor Service) makes.
 * It defines what operations related to doctors can be performed.
 */
public interface DoctorService {

    /**
     * Creates a new doctor record.
     * @param doctorRequestDTO The form filled by the new doctor.
     * @return The summary form of the created doctor.
     */
    DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO);

    /**
     * Retrieves a doctor's summary form by their unique ID.
     * @param id The unique ID of the doctor.
     * @return The doctor's summary form.
     */
    DoctorResponseDTO getDoctorById(UUID id);

    /**
     * Retrieves all doctor summary forms.
     * @return A list of all doctor summary forms.
     */
    List<DoctorResponseDTO> getAllDoctors();

    /**
     * Updates an existing doctor's information.
     * @param id The unique ID of the doctor to update.
     * @param doctorUpdateDTO The form with updated doctor details.
     * @return The updated doctor's summary form.
     */
    DoctorResponseDTO updateDoctor(UUID id, DoctorUpdateDTO doctorUpdateDTO);

    /**
     * Deletes a doctor record by their unique ID.
     * @param id The unique ID of the doctor to delete.
     */
    void deleteDoctor(UUID id);
}