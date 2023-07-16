package com.aaronbujatin.delorianhotelbackend.controller;

import com.aaronbujatin.delorianhotelbackend.model.Booking;
import com.aaronbujatin.delorianhotelbackend.model.Guest;
import com.aaronbujatin.delorianhotelbackend.model.Room;
import com.aaronbujatin.delorianhotelbackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
@CrossOrigin("*")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/list")
    public ResponseEntity<List<Room>> availableRooms(@RequestParam("checkinDate") @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate checkin,
                                                     @RequestParam("checkoutDate") @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate checkOut){
        return new ResponseEntity<>(bookingService.availableRooms(checkin, checkOut), HttpStatus.OK);
    }

    @PostMapping("/{roomId}")
    public ResponseEntity<Booking> saveBooking(@PathVariable("roomId") Long id, @RequestBody Guest guest){
        return new ResponseEntity<Booking>(bookingService.saveBooking(id, guest), HttpStatus.CREATED);
    }


}
