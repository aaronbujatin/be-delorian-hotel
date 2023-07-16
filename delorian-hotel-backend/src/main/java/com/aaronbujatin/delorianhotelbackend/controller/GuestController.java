package com.aaronbujatin.delorianhotelbackend.controller;

import com.aaronbujatin.delorianhotelbackend.model.Guest;
import com.aaronbujatin.delorianhotelbackend.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/guests")
@CrossOrigin("*")
public class GuestController {

    private final GuestService guestService;

    @PostMapping                
    public ResponseEntity<Guest> saveGuest(@RequestBody Guest guest){
        return new ResponseEntity<Guest>(guestService.saveGuest(guest), HttpStatus.CREATED);
    }



}
