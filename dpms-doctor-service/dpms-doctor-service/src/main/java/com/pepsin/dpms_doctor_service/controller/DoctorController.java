package com.pepsin.dpms_doctor_service.controller;

import com.pepsin.dpms_doctor_service.DTO.DoctorRequestDTO;
import com.pepsin.dpms_doctor_service.DTO.DoctorResponseDTO;
import com.pepsin.dpms_doctor_service.DTO.DoctorUpdateDTO;
import com.pepsin.dpms_doctor_service.model.Doctor;
import com.pepsin.dpms_doctor_service.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> createDoctor(@Valid @RequestBody DoctorRequestDTO patientRequestDTO) {
        DoctorResponseDTO createdDoctor= doctorService.createDoctor(patientRequestDTO);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable UUID id) {
        DoctorResponseDTO doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor); // Shorthand for new ResponseEntity<>(patient, HttpStatus.OK)
    }


    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        List<DoctorResponseDTO> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable UUID id,
                                                            @RequestBody DoctorUpdateDTO doctorUpdateDTO) {
        DoctorResponseDTO updatedDoctor = doctorService.updateDoctor(id, doctorUpdateDTO);
        return ResponseEntity.ok(updatedDoctor);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable UUID id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
