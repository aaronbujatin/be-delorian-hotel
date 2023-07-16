package com.aaronbujatin.delorianhotelbackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_booking")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Room room;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Guest guest;

}
