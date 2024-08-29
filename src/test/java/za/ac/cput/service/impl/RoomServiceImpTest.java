package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Room;

import java.io.IOException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoomServiceImpTest {

    @Autowired
    private RoomServiceImp roomService;
    private static Room room;

    @BeforeEach
    void setUp() throws IOException {


    }

    @Test
    @Order(1)
    void create() {
    }

    @Test
    @Order(2)
    void read() {
    }

    @Test
    @Order(3)
    void update() {
    }

    @Test
    @Order(6)
    void delete() {
    }

    @Test
    @Order(5)
    void getAll() {
    }

    @Test
    @Order(4)
    void uploadImage() throws IOException {

    }

}