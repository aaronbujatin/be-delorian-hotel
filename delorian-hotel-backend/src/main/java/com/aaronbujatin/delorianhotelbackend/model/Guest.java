package com.aaronbujatin.delorianhotelbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity(name = "tbl_guest")
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String state;
    private String city;
    private String additionalDetails;
    private LocalDate checkin;
    private LocalDate checkout;
    private int cardNumber;
    private double payment;

}
