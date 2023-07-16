package com.aaronbujatin.delorianhotelbackend.controller;

import com.aaronbujatin.delorianhotelbackend.model.Room;
import com.aaronbujatin.delorianhotelbackend.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("*")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        return new ResponseEntity<>(roomService.createRoom(room), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Room> updateRoom(@RequestBody Room room){
        return ResponseEntity.accepted().body(roomService.updateRoom(room));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Room>> getRooms(){                   
        return ResponseEntity.ok(roomService.getRooms());
    }
}
