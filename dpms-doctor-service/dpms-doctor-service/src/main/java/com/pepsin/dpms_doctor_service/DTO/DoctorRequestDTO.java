package com.pepsin.dpms_doctor_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * This is our "New Doctor Registration Form".
 * Used when someone wants to add a new doctor to the system.
 * Includes validation rules to ensure correct information.
 */
public class DoctorRequestDTO {

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Specialty cannot be empty")
    private String specialty;

    @NotBlank(message = "Contact number cannot be empty")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits")
    private String contactNumber;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Office address cannot be empty")
    private String officeAddress;

    public @NotBlank(message = "First name cannot be empty") @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First name cannot be empty") @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Last name cannot be empty") @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Last name cannot be empty") @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Specialty cannot be empty") String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(@NotBlank(message = "Specialty cannot be empty") String specialty) {
        this.specialty = specialty;
    }

    public @NotBlank(message = "Contact number cannot be empty") @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotBlank(message = "Contact number cannot be empty") @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public @NotBlank(message = "Email cannot be empty") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email cannot be empty") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Office address cannot be empty") String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(@NotBlank(message = "Office address cannot be empty") String officeAddress) {
        this.officeAddress = officeAddress;
    }
}