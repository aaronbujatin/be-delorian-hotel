package com.aaronbujatin.delorianhotelbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_room")
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int number;
    private String type;
    private double price;
    private  String imageUrl;
    private List<String> amenities;
    private boolean isAvailable;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Booking> bookingList;



}
