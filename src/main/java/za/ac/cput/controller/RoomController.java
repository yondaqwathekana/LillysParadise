package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
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
    public Room readRoom(@PathVariable String RoomNumber){ return RoomService.read(RoomNumber); }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room){ return RoomService.update(room); }

    @DeleteMapping("/delete/{roomNumber}")
    public ResponseEntity<?> deleteRoom(@PathVariable String roomNumber){
        try {
            Room deletedRoom = RoomService.delete(roomNumber);
            if (deletedRoom != null) {
                return new ResponseEntity<>(deletedRoom, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Room not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting room", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getall")
    public Set<Room> getRooms(){ return RoomService.getAll(); }

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
}
