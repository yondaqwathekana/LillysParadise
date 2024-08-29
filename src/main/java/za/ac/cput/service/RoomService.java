package za.ac.cput.service;


import za.ac.cput.domain.Room;

import java.util.Set;

public interface RoomService extends IService<Room, String>{
    public Room delete(String RoomNumber);
    Set<Room> getAll();
}
