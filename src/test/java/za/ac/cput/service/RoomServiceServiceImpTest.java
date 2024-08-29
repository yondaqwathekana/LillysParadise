package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.RoomService;
import za.ac.cput.factory.RoomServiceFactory;
import za.ac.cput.service.impl.RoomServiceServiceImp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceServiceImpTest {

    @Autowired
    private RoomServiceServiceImp service;

    RoomService room = RoomServiceFactory.createRoomService("Breakfast","Vegan",500.00);

    @Test
    void create(){
        RoomService created = service.create(room);
        assertNotNull(created);
        System.out.println(created);
    }
    @Test
    void read(){
        RoomService read = service.read(room.getServiceName());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test

    void update(){
        RoomService update = service.update(new RoomService.Builder().copy(room).setServiceName("launch").build());
    }

    @Test
    void getAll(){
        System.out.println(service.getAll());
    }
}