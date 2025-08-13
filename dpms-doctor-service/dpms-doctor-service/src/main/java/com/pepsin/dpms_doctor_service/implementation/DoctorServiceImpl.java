package com.pepsin.dpms_doctor_service.implementation;

import com.pepsin.dpms_doctor_service.DTO.DoctorRequestDTO;
import com.pepsin.dpms_doctor_service.DTO.DoctorResponseDTO;
import com.pepsin.dpms_doctor_service.DTO.DoctorUpdateDTO;
import com.pepsin.dpms_doctor_service.exception.ResourceNotFoundException;
import com.pepsin.dpms_doctor_service.model.Doctor;
import com.pepsin.dpms_doctor_service.repository.DoctorRepository;
import com.pepsin.dpms_doctor_service.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This is the "Doctor's Office Manager" who actually does the work.
 * It implements the promises made in the DoctorService interface.
 * This class contains the "business logic" (the rules of our doctor's office).
 *
 * @Service: Tells Spring that this class is a "Service" component.
 * @RequiredArgsConstructor (from Lombok): Automatically creates a constructor
 * that injects the DoctorRepository.
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Converts a DoctorRequestDTO (form) into a Doctor entity (record card).
     * @param dto The request DTO.
     * @return The Doctor entity.
     */
    private Doctor mapToEntity(DoctorRequestDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setContactNumber(dto.getContactNumber());
        doctor.setEmail(dto.getEmail());
        doctor.setOfficeAddress(dto.getOfficeAddress());
        return doctor;
    }

    /**
     * Converts a Doctor entity (record card) into a DoctorResponseDTO (summary form).
     * @param doctor The Doctor entity.
     * @return The response DTO.
     */
    private DoctorResponseDTO mapToDTO(Doctor doctor) {
        DoctorResponseDTO dto = new DoctorResponseDTO();
        dto.setId(doctor.getId());
        dto.setFirstName(doctor.getFirstName());
        dto.setLastName(doctor.getLastName());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setContactNumber(doctor.getContactNumber());
        dto.setEmail(doctor.getEmail());
        dto.setOfficeAddress(doctor.getOfficeAddress());
        return dto;
    }

    /**
     * Creates a new doctor record.
     * 1. Takes the DoctorRequestDTO (form).
     * 2. Converts it into a Doctor entity (record card).
     * 3. Asks the Librarian (doctorRepository) to save the new record.
     * 4. Converts the saved Doctor entity back into a DoctorResponseDTO (summary form).
     * 5. Returns the summary form.
     */
    @Override
    public DoctorResponseDTO createDoctor(DoctorRequestDTO doctorRequestDTO) {
        // You might add a check here if a doctor with this email already exists
        Optional<Doctor> existingDoctor = doctorRepository.findByEmail(doctorRequestDTO.getEmail());
        if (existingDoctor.isPresent()) {
            throw new IllegalArgumentException("Doctor with this email already exists.");
        }

        Doctor doctor = mapToEntity(doctorRequestDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return mapToDTO(savedDoctor);
    }

    /**
     * Retrieves a doctor's summary form by their unique ID.
     * 1. Asks the Librarian (doctorRepository) to find the record card by ID.
     * 2. If found, converts it to a summary form and returns it.
     * 3. If NOT found, throws a "ResourceNotFoundException".
     */
    @Override
    public DoctorResponseDTO getDoctorById(UUID id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        return mapToDTO(doctor);
    }

    /**
     * Retrieves all doctor summary forms.
     * 1. Asks the Librarian (doctorRepository) for all record cards.
     * 2. Converts each record card into a summary form.
     * 3. Returns a list of all summary forms.
     */
    @Override
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }



    /**
     * Updates an existing doctor's information.
     * 1. Finds the existing doctor record card by ID.
     * 2. If found, updates the fields with new information from the DoctorUpdateDTO.
     * 3. Asks the Librarian (doctorRepository) to save the updated record.
     * 4. Converts the updated record card to a summary form and returns it.
     * 5. If NOT found, throws a "ResourceNotFoundException".
     */
    @Override
    public DoctorResponseDTO updateDoctor(UUID id, DoctorUpdateDTO doctorUpdateDTO) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

        // Update fields only if they are provided in the DTO
        Optional.ofNullable(doctorUpdateDTO.getFirstName()).ifPresent(existingDoctor::setFirstName);
        Optional.ofNullable(doctorUpdateDTO.getLastName()).ifPresent(existingDoctor::setLastName);
        Optional.ofNullable(doctorUpdateDTO.getSpecialty()).ifPresent(existingDoctor::setSpecialty);
        Optional.ofNullable(doctorUpdateDTO.getContactNumber()).ifPresent(existingDoctor::setContactNumber);
        Optional.ofNullable(doctorUpdateDTO.getEmail()).ifPresent(existingDoctor::setEmail);
        Optional.ofNullable(doctorUpdateDTO.getOfficeAddress()).ifPresent(existingDoctor::setOfficeAddress);

        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return mapToDTO(updatedDoctor);
    }

    /**
     * Deletes a doctor record by their unique ID.
     * 1. Checks if the doctor record exists.
     * 2. If it exists, asks the Librarian (doctorRepository) to delete it.
     * 3. If NOT found, throws a "ResourceNotFoundException".
     */
    @Override
    public void deleteDoctor(UUID id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}