package com.aaronbujatin.delorianhotelbackend.repository;

import com.aaronbujatin.delorianhotelbackend.model.Booking;
import com.aaronbujatin.delorianhotelbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking>  findByRoomAndCheckOutDateGreaterThanEqualAndCheckInDateLessThanEqual(Room room, LocalDate endDate, LocalDate startDate);


}
