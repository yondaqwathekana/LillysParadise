package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.RoomService;
import za.ac.cput.factory.RoomServiceFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoomSControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static String Base_URL = "http://localhost:8080/roomService";
    private static RoomService roomService1, roomService2;

    @BeforeAll
    static void setUp() {
        roomService1 = RoomServiceFactory.createRoomService("Cleaning", "Daily room cleaning", 100.00);
        roomService2 = RoomServiceFactory.createRoomService("Laundry", "Laundry service", 50.00);
    }

    @Test
    @Order(1)
    void createRoomService() {
        String createURL = Base_URL + "/create";
        ResponseEntity<RoomService> response1 = restTemplate.postForEntity(createURL, roomService1, RoomService.class);
        ResponseEntity<RoomService> response2 = restTemplate.postForEntity(createURL, roomService2, RoomService.class);
        RoomService roomService1Saved = response1.getBody();
        RoomService roomService2Saved = response2.getBody();
        assertNotNull(roomService1Saved);
        assertNotNull(roomService2Saved);
        assertEquals(roomService1.getServiceName(), roomService1Saved.getServiceName());
        assertEquals(roomService2.getServiceName(), roomService2Saved.getServiceName());
        System.out.println("Room Service 1 Saved: ServiceName " + roomService1Saved.getServiceName());
        System.out.println("Room Service 2 Saved: ServiceName " + roomService2Saved.getServiceName());
    }

    @Test
    @Order(2)
    void readRoomService() {
        String readURL = Base_URL + "/read/" + roomService1.getServiceName();
        ResponseEntity<RoomService> response = restTemplate.getForEntity(readURL, RoomService.class);
        RoomService roomServiceRead = response.getBody();
        assertNotNull(roomServiceRead);
        assertEquals(roomService1.getServiceName(), roomServiceRead.getServiceName());
        System.out.println("Room Service Read: ServiceName " + roomServiceRead.getServiceName());
    }

    @Test
    @Order(3)
    void updateRoomService() {
        String updateURL = Base_URL + "/update";
        roomService1 = new RoomService.Builder().copy(roomService1).setServiceDescription("Updated Daily room cleaning").build();
        restTemplate.put(updateURL, roomService1);
        ResponseEntity<RoomService> response = restTemplate.getForEntity(updateURL, RoomService.class);
        RoomService updatedRoomService = response.getBody();
        assertNotNull(updatedRoomService);
        assertEquals("Updated Daily room cleaning", updatedRoomService.getServiceDescription());
        System.out.println("Room Service Updated: Description " + updatedRoomService.getServiceDescription());
    }

    @Test
    @Order(4)
    void getAllRoomServices() {
        String getAllURL = Base_URL + "/getall";
        ResponseEntity<Set> response = restTemplate.getForEntity(getAllURL, Set.class);
        Set roomServices = response.getBody();
        assertNotNull(roomServices);
        assertTrue(roomServices.size() > 0);
        System.out.println("All Room Services Retrieved: " + roomServices.size());
    }

}