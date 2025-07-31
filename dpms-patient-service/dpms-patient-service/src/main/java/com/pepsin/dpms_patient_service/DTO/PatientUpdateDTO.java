package com.pepsin.dpms_patient_service.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

/**
 * This is our "Update Patient Information Form".
 * When someone wants to change existing patient details, they fill out this form.
 * Fields can be optional here, as not all fields might be updated at once.
 *
 * @Data (from Lombok): Automatically generates getters, setters, toString(), etc.
 * Validation Annotations are similar to PatientRequestDTO, but some fields might not be @NotBlank
 * if they are optional for updates.
 */
//@Data // Lombok: Generates getters, setters, equals, hashCode, and toString
public class PatientUpdateDTO {

    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @PastOrPresent(message = "Date of birth cannot be in the future")
    private LocalDate dateOfBirth;

    private String gender;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits")
    private String contactNumber;

    @Email(message = "Email should be valid")
    private String email;

    private String address;

    public PatientUpdateDTO() {
    }

    public PatientUpdateDTO(String firstName, String lastName, LocalDate dateOfBirth, String gender, String contactNumber, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.email = email;
    }

    public @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String firstName) {
        this.firstName = firstName;
    }

    public @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public @PastOrPresent(message = "Date of birth cannot be in the future") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@PastOrPresent(message = "Date of birth cannot be in the future") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be 10-15 digits") String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid") String email) {
        this.email = email;
    }
}
