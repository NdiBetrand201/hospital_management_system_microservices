package com.pepsin.dpms_doctor_service.DTO;

import lombok.Data;
import java.util.UUID;

/**
 * This is our "Doctor Summary Form".
 * Used when sending doctor information back to the client.
 * Contains only the details we want to expose.
 */

public class DoctorResponseDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String contactNumber;
    private String email;
    private String officeAddress;

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
