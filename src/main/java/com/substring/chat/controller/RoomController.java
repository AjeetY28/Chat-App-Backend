package com.substring.chat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.substring.chat.entities.Room;
import com.substring.chat.repositories.RoomRepository;



@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository)
    {
        this.roomRepository=roomRepository;
    }
    //create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId)
    {
        if(roomRepository.findByRoomId(roomId)!=null)
        {
            //room is already there 

            return ResponseEntity.badRequest().body("Room already exists");
        }

        Room room=new Room();
        room.setRoomId(roomId);
        Room savedRoom =roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);        
    }



    //get rooom
   
}