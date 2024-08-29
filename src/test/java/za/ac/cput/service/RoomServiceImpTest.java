package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Room;
import za.ac.cput.factory.RoomFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceImpTest {

    @Autowired
    private RoomService service;

    Room room = RoomFactory.createRoom("C619", "Double", 500.00,"6thfoor");
    @Test
    void create(){
        Room created = service.create(room);
        assertNotNull(room);
        System.out.println(room);
    }

    @Test
    void read(){

        Room read = service.read(room.getRoomNumber());
        assertNotNull(read);
        System.out.println(read);
    }
    void update(){
        Room update = service.update(new Room.Builder().copy(room).setRoomNumber("A619").build());
        assertNotNull(update);
        System.out.println(update);
    }

    @Test
    void getAll(){
        System.out.println(service.getAll());
    }
}