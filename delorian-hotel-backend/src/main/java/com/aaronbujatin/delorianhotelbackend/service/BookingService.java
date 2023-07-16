package com.aaronbujatin.delorianhotelbackend.service;

import com.aaronbujatin.delorianhotelbackend.exception.NotFoundException;
import com.aaronbujatin.delorianhotelbackend.model.Guest;
import com.aaronbujatin.delorianhotelbackend.model.Room;
import com.aaronbujatin.delorianhotelbackend.repository.BookingRepository;
import com.aaronbujatin.delorianhotelbackend.repository.GuestRepository;
import com.aaronbujatin.delorianhotelbackend.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aaronbujatin.delorianhotelbackend.model.Booking;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public List<Room> availableRooms(LocalDate selectedCheckInDate, LocalDate selectedCheckOutDate){

        List<Room> rooms = roomRepository.findAll();

        for (Room room : rooms) {
            List<Booking> reservations = bookingRepository.findByRoomAndCheckOutDateGreaterThanEqualAndCheckInDateLessThanEqual(
                    room, selectedCheckInDate, selectedCheckOutDate);
            if (!reservations.isEmpty()) {
                room.setAvailable(false);
            }

        }
        List<Room> availableRooms = rooms.stream()
                .filter(Room::isAvailable)
                .collect(Collectors.toList());

        return availableRooms;
    }

    public Booking saveBooking(Long roomId, Guest guest){

        Room room = roomRepository.findById(roomId).orElseThrow(() -> new NotFoundException("Room id : " + roomId + " was not found"));
        Booking booking = new Booking();
        booking.setCheckInDate(guest.getCheckin());
        booking.setCheckOutDate(guest.getCheckout());
        booking.setRoom(room);
        booking.setGuest(guest);
        guestRepository.save(guest);
        return  bookingRepository.save(booking);
    }

}
