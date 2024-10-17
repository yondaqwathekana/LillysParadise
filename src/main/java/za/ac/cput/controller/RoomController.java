package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Room;

import za.ac.cput.repository.RoomRepository;
import za.ac.cput.service.impl.RoomServiceImp;
import za.ac.cput.util.FileUtils;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/room")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class RoomController {

    private final RoomServiceImp RoomService;
    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomServiceImp RoomService, RoomRepository roomRepository) {
        this.RoomService = RoomService;
        this.roomRepository = roomRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRoom(@RequestPart("room") String roomJson, @RequestPart(value = "image", required = false) MultipartFile image) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Room room = mapper.readValue(roomJson, Room.class);

            Room createdRoom = image != null && !image.isEmpty()
                    ? RoomService.createRoomWithImage(room, image)
                    : RoomService.create(room);

            return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating room", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read/{RoomNumber}")
    public ResponseEntity<Room> readRoom(@PathVariable String RoomNumber) {
        try {
            Room readRoom = RoomService.read(RoomNumber);
            return new ResponseEntity<>(readRoom, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        try {
            Room updateRoom = RoomService.update(room);
            return new ResponseEntity<>(updateRoom, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{roomNumber}")
    public ResponseEntity<?> deleteRoom(@PathVariable String roomNumber) {
        try {
            Room deletedRoom = RoomService.delete(roomNumber);
            if (deletedRoom != null) {
                return new ResponseEntity<>(deletedRoom, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Room not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("Error deleting room", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<Set<Room>> getRooms() {
        try{
            Set<Room> rooms = RoomService.getAll();
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/image/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) {
        // Fetch the image from the repository or file system
        Optional<Room> roomOptional = roomRepository.findRoomByImageName(imageName);
        if (roomOptional.isPresent()) {
            System.out.println("room with image was found");
            Room room = roomOptional.get();
            byte[] imageBytes = FileUtils.decompressImageFile(room.getImage());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(room.getImageType()));
            headers.setContentDisposition(ContentDisposition.builder("inline").filename(room.getImageName()).build());
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            System.out.println("room with image not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{roomType}")
    public ResponseEntity<Set<Room>> getRoomByType(@PathVariable String roomType) {
        if (roomType != null && !roomType.isEmpty()) {
            Set<Room> rooms = RoomService.findByRoomType(roomType);
            if (rooms.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Room type must be provided");
        }
    }
}
