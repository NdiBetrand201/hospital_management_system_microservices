package com.pepsin.dpms_patient_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

/**
 * This is our "New Patient Registration Form".
 * When someone wants to create a new patient record, they fill out this form.
 * It contains only the information needed to create a patient, and we can add rules
 * to make sure the information is correct.
 *
 * @Data (from Lombok): Automatically generates getters, setters, toString(), etc.
 *
 * Validation Annotations (from Jakarta Validation API):
 * - @NotBlank: Means the string cannot be null and must contain at least one non-whitespace character.
 * - @Size(min = X, max = Y): Means the string must be between X and Y characters long.
 * - @Email: Checks if the string looks like a valid email address.
 * - @NotNull: Means the field cannot be null.
 * - @PastOrPresent: Means the date must be in the past or today.
 * - @Pattern: Checks if the string matches a specific pattern (like for phone numbers).
 */
//@Data // Lombok: Generates getters, setters, equals, hashCode, and toString
public class PatientRequestDTO {

    @NotBlank(message = "First name cannot be empty") // Must not be empty
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Date of birth cannot be null")
    @PastOrPresent(message = "Date of birth cannot be in the future")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    @NotBlank(message = "Contact number cannot be empty")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") // Example: 10-15 digits
    private String contactNumber;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid") // Must be a valid email format
    private String email;

    @NotBlank(message = "Address cannot be empty")
    private String address;


    public PatientRequestDTO() {
    }

    public PatientRequestDTO(String firstName, String lastName, LocalDate dateOfBirth, String gender, String contactNumber, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }

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

    public @NotNull(message = "Date of birth cannot be null") @PastOrPresent(message = "Date of birth cannot be in the future") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "Date of birth cannot be null") @PastOrPresent(message = "Date of birth cannot be in the future") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotBlank(message = "Contact number cannot be empty") @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotBlank(message = "Contact number cannot be empty") @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public @NotBlank(message = "Gender cannot be empty") String getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "Gender cannot be empty") String gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "Email cannot be empty") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email cannot be empty") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address cannot be empty") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address cannot be empty") String address) {
        this.address = address;
    }
}

