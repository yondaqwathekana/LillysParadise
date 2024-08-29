package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Amenity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AmenityFactoryTest {
    private static Amenity amenity;
    LocalDateTime createdDateTime = LocalDateTime.now();
    LocalDateTime updatedDateTime = LocalDateTime.now();


    @BeforeEach
    void setUp(){


        amenity = AmenityFactory.createAmenity("1234567", "Wi-Fi","NETGEAR R9000-100NAR Nighthawk X10 AD7200", true);
    }
    @Test
    void createAmenity() {
        assertNotNull(amenity);
        System.out.println(amenity);


    }
}