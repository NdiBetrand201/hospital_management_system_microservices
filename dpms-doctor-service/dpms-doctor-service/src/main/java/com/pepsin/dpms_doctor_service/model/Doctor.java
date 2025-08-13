package com.pepsin.dpms_doctor_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * This is our "Doctor Record Card" blueprint.
 * It describes what information we store about each doctor in their digital filing cabinet.
 *
 * @Entity: Tells Spring and our database tools that this Java class should be saved in a database table.
 * @Table(name = "doctors"): Tells the database to name the table 'doctors'.
 * @Data (from Lombok): Automatically writes getters, setters, and toString().
 * @NoArgsConstructor (from Lombok): Creates an empty constructor.
 * @AllArgsConstructor (from Lombok): Creates a constructor with all fields.
 */
@Entity
@Table(name = "doctors")

public class Doctor {

    /**
     * @Id: Marks this field as the unique ID for each doctor record.
     * @GeneratedValue(strategy = GenerationType.AUTO): Tells the database to automatically
     * make up a new unique ID (UUID) for each new doctor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String specialty; // E.g., "Cardiology", "Pediatrics", "General Practice"

    private String contactNumber;

    @Column(unique = true, nullable = false)
    private String email;

    // In a real system, you might add more complex availability (e.g., a separate Availability entity)
    // For simplicity, we'll keep it basic for now.
    private String officeAddress;

    public Doctor() {
    }

    public Doctor(UUID id, String firstName, String lastName, String specialty, String contactNumber, String email, String officeAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.contactNumber = contactNumber;
        this.email = email;
        this.officeAddress = officeAddress;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }
}
