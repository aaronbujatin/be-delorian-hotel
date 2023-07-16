package com.aaronbujatin.delorianhotelbackend.service;

import com.aaronbujatin.delorianhotelbackend.model.Guest;
import com.aaronbujatin.delorianhotelbackend.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public Guest saveGuest(Guest guest){


        return guestRepository.save(guest);
    }
}
