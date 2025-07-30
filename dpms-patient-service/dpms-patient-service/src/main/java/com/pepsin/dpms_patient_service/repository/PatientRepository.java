package com.pepsin.dpms_patient_service.repository;

import com.pepsin.dpms_patient_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

/**
 * This is our "Filing Cabinet Librarian" for patient records.
 * Spring Data JPA is amazing because we just need to create this interface,
 * and Spring automatically creates all the code needed to talk to the database
 * for common tasks like saving, finding, and deleting patients!
 *
 * @Repository: This sticker tells Spring that this interface is responsible
 * for talking to the database.
 *
 * JpaRepository<Patient, UUID>:
 * - 'Patient': This tells the librarian that it's managing 'Patient' record cards.
 * - 'UUID': This tells the librarian that the unique ID for these cards is a 'UUID' type.
 *
 * By extending JpaRepository, we automatically get methods like:
 * - save(Patient patient): To put a new card in or update an existing one.
 * - findById(UUID id): To find a card by its unique ID.
 * - findAll(): To get all patient cards.
 * - deleteById(UUID id): To throw away a card.
 *
 * We can also add our own special methods here, and Spring will try to figure out
 * how to do them based on the method name!
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    // Spring Data JPA can automatically create queries based on method names!
    // This method will find a patient by their email address.
    Optional<Patient> findByEmail(String email);
}
