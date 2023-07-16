package com.aaronbujatin.delorianhotelbackend.service;

import com.aaronbujatin.delorianhotelbackend.exception.NotFoundException;
import com.aaronbujatin.delorianhotelbackend.model.Room;
import com.aaronbujatin.delorianhotelbackend.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    public List<Room> getRooms(){
        return roomRepository.findAll();
    }

    public Room createRoom(Room room){
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room){
        return roomRepository.save(room);
    }

    public Room getRoomById(Long id){
        return roomRepository.findById(id).orElseThrow(() -> new NotFoundException("Room id: " + id + " was not found"));
    }
}
