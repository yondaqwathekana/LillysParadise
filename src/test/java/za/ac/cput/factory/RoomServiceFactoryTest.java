package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.RoomService;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceFactoryTest {

    @Test
    void testCreateRoomService() {
        // Create a RoomService using the factory
        RoomService roomService = RoomServiceFactory.createRoomService("Breakfast", "Continental breakfast", 100.00);

        // Verify that the RoomService object is not null
        assertNotNull(roomService);

        // Verify that the RoomService object has the expected attributes
        assertEquals("Breakfast", roomService.getServiceName());
        assertEquals("Continental breakfast", roomService.getServiceDescription());
        assertEquals(100.00, roomService.getServicePrice());

        // Optionally print the object to the console for manual verification
        System.out.println(roomService.toString());
    }
}
