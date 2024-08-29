package za.ac.cput.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.io.IOException;
import java.util.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String Base_URL = "http://localhost:8080/room";
    private static Room room1;

    @BeforeEach
    void setUp() throws IOException {

    }

    @Test
    @Order(1)
    void createRoom() {

    }

    @Test
    @Order(2)
    void readRoom() {
        String readURL = Base_URL + "/read/" + room1.getRoomNumber();
        System.out.println("URL: " + readURL);
        ResponseEntity<Room> response = restTemplate.getForEntity(readURL, Room.class);
        Room roomRead = response.getBody();
        assertNotNull(roomRead);
        assertEquals(room1.getRoomNumber(), roomRead.getRoomNumber());
        System.out.println("Room Read: RoomNumber " + roomRead.getRoomNumber());
    }

    @Test
    @Order(3)
    void updateRoom() {
    }

    @Test
    @Order(4)
    void getAllRooms() {
    }

}
