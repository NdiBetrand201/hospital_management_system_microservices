package com.pepsin.dpms_patient_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This is our "Patient Record Card" blueprint.
 * It describes what information we store about each patient in our digital filing cabinet (database).
 *
 * @Entity: This sticker tells Spring and our database tools that this Java class
 * is a "thing" that should be saved in a database table.
 * @Table(name = "patients"): This sticker tells the database what to name the table
 * where these patient records will be kept.
 * @Data (from Lombok): This is a super helper! It automatically writes boring code for us,
 * like methods to get and set values (getFirstName(), setFirstName()),
 * and a method to print the object nicely (toString()).
 * @NoArgsConstructor (from Lombok): Automatically creates an empty constructor (Patient()).
 * @AllArgsConstructor (from Lombok): Automatically creates a constructor with all fields (Patient(id, firstName, ...)).
 */
@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    /**
     * @Id: This sticker marks this field as the unique ID for each patient record.
     * Think of it as the patient's special number that no one else has.
     * @GeneratedValue(strategy = GenerationType.AUTO): This tells the database to automatically
     * make up a new unique ID for each new patient.
     * UUID (Universally Unique Identifier) is a very long,
     * random number, great for unique IDs in microservices.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false) // This means this field cannot be empty in the database
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate dateOfBirth; // Stores the patient's birthday

    private String gender;

    private String contactNumber;

    @Column(unique = true) // This means no two patients can have the same email address
    private String email;

    private String address;
}
