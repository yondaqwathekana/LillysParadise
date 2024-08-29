package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.RoomService;
import za.ac.cput.repository.RoomServiceRepository;
import za.ac.cput.service.RoomServiceService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class RoomServiceServiceImp implements RoomServiceService {

    private final RoomServiceRepository repository;

    @Autowired
    public RoomServiceServiceImp(RoomServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomService create(RoomService roomService) {
        return repository.save(roomService);
    }

    @Override
    public RoomService read(String serviceName) {
        return repository.findById(serviceName).orElseThrow(() -> new NoSuchElementException("No room service with such name exists"));
    }

    @Override
    public RoomService update(RoomService roomService) {
        return repository.save(roomService);
    }

    @Override
    public RoomService delete(String serviceName) {
        RoomService roomServiceToDelete = read(serviceName);
        if (roomServiceToDelete != null) {
            repository.delete(roomServiceToDelete);
        }
        return roomServiceToDelete;
    }

    @Override
    public Set<RoomService> getAll() {
        return new HashSet<>(repository.findAll());
    }
}
