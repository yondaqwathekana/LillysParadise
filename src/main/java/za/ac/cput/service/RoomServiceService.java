package za.ac.cput.service;

import za.ac.cput.domain.Room;
import za.ac.cput.domain.RoomService;

import java.util.Set;

public interface RoomServiceService  extends IService<RoomService, String>{

    public RoomService delete(String serviceName);
    Set<RoomService> getAll();
}
