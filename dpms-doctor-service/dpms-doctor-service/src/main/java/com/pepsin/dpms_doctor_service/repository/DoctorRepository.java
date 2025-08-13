package com.pepsin.dpms_doctor_service.repository;

import com.pepsin.dpms_doctor_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

/**
 * This is our "Filing Cabinet Librarian" for doctor records.
 * Just like for patients, Spring Data JPA automatically provides methods
 * to save, find, and delete doctor records by simply extending JpaRepository.
 *
 * @Repository: Tells Spring this interface is for database interaction.
 * JpaRepository<Doctor, UUID>: Manages 'Doctor' record cards, identified by 'UUID'.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    // We can add custom methods here. Spring will figure out how to find a doctor by email.
    Optional<Doctor> findByEmail(String email);
}
