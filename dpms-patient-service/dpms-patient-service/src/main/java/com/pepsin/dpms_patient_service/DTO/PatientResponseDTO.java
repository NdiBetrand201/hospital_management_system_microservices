package com.pepsin.dpms_patient_service.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This is our "Patient Summary Form".
 * When someone asks for patient information, the Hospital gives back this form.
 * It contains only the information we want to show to the outside world,
 * hiding any sensitive internal details that might be on the full Patient Record Card.
 *
 * @Data (from Lombok): Automatically generates getters, setters, toString(), etc.
 */
//@Data // Lombok: Generates getters, setters, equals, hashCode, and toString
public class PatientResponseDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String contactNumber;
    private String email;
    private String address;
    // We could add more fields here if needed, or remove some if they are sensitive
    // For example, we might not return the full address or contact in some cases.


    public PatientResponseDTO() {
    }

    public PatientResponseDTO(UUID id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String contactNumber, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
