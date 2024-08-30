package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Room;
import za.ac.cput.repository.RoomRepository;
import za.ac.cput.service.RoomService;
import za.ac.cput.util.FileUtils;

import java.io.IOException;
import java.util.*;

@Service
public class RoomServiceImp implements RoomService {

    private final RoomRepository repository;
    @Autowired
    public RoomServiceImp(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Room create(Room room) { return repository.save(room); }
    public Room createRoomWithImage(Room room, MultipartFile file) throws IOException, DataAccessException {
        if (room == null) { throw new NoSuchElementException("Fill room details"); }
        room = new Room.Builder().copy(room)
                .setImageName(file.getOriginalFilename())
                .setImageType(file.getContentType())
                .setImage(FileUtils.compressImageFile(file.getBytes()))
                .build();

        return repository.save(room);
    }


    public Set<Room> findByRoomType(String roomType){ return repository.findRoomByRoomType(roomType); }


    @Override
    public Room read(String RoomNumber) { return repository.findById(RoomNumber).orElseThrow(()-> new NoSuchElementException("No room with such email address exist")); }
    @Override
    public Room update(Room room) { return repository.save(room); }

    public Room delete(String roomNumber) {
        Room roomToDelete = read(roomNumber);
        if (roomToDelete != null) {
            repository.delete(roomToDelete);
            String imageName = roomToDelete.getImageName();
            if (imageName != null && !imageName.isEmpty()) {
                FileUtils.deleteImageFile(imageName);
            }
        }
        return roomToDelete;
    }
    @Override
    public Set<Room> getAll() { return new HashSet<>(repository.findAll()); }

}