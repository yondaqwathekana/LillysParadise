package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingControllerTest {
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private static String BASE_URL = "http://localhost:8080/bookings";
//    private static Contact contact;
//    private static Name name;
//    private static LocalDateTime createdDateTime = LocalDateTime.now();
//    private static LocalDateTime updatedDateTime = LocalDateTime.now();
//    private static Room room;
//    private static Guest guest;
//    private static Booking booking;
//
//
//    @BeforeAll
//    static void setUp() {
//        // admin 1
//        contact = ContactFactory.builContact("oyo@gmail.com", "0687568765", "0784909331");
//        name = NameFactory.createName("Oyola", "Zukhanye", "Mpiko");
//        guest = GuestFactory.createGuest("60005", name, contact, "password1");
//
//        UUID imageId = UUID.randomUUID();
//        String description = "Beautiful View";
//        String filePath = "/images/rooms/dwns_ocean_img_3138_nova9d40b0.webp";
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(imageId, description, filePath, imageData, createdDateTime, updatedDateTime);
//
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image1);
//
//        room = RoomFactory.createRoom("505", "Deluxe", 900.00, "2", imageSet);
//        LocalDateTime checkIn = LocalDateTime.parse("2023-05-16T12:30:10");
//        LocalDateTime checkOut = LocalDateTime.parse("2023-06-10T12:30:10");
//        booking = BookingFactory.createBooking("123", checkIn, checkOut, room, guest);
//    }
//
//
//    @Test
//    @Order(1)
//    void createBooking() {
//        String createURL = BASE_URL + "/create";
//        System.out.println("URL: " + createURL);
//        ResponseEntity<Booking> response1 = restTemplate.postForEntity(createURL, booking, Booking.class);
//        assertNotNull(response1.getBody());
//        System.out.println(response1.getBody());
//
//    }
//
//    @Test
//    @Order(2)
//    void readBooking() {
//        String bookingId1 = booking.getBookingId();
//        String readURL = BASE_URL + "/read/" + bookingId1;
//        System.out.println("URL: " + readURL);
//        ResponseEntity<Booking> response1 = restTemplate.getForEntity(readURL, Booking.class);
//        assertNotNull(response1.getBody());
//        System.out.println("Read: " + response1.getBody());
//    }
//
//    @Test
//    @Order(3)
//    void updateBooking() {
////        String updateURL = BASE_URL + "/update";
////        System.out.println("URL: " + updateURL);
////        Name nameUpdate = new Name.Builder().copy(name).setMiddleName("Dominique").build();
////        Booking bookingUpdate = BookingFactory.createBooking(booking4.getBookingId(), checkIn, checkOut, room, guest);
////        assert bookingUpdate != null;
////        HttpEntity<Booking> entity = new HttpEntity<>(bookingUpdate);
////        ResponseEntity<Booking> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Booking.class);
////        assertNotNull(response.getBody());
////        System.out.println(response.getBody());
//    }
//
//    @Test
//    @Order(4)
//    void deleteBooking() {
////        String bookingId3 = booking3.getBookingId();
////        String deleteURL = BASE_URL + "/delete/" + bookingId3;
////        System.out.println("URL: " + deleteURL);
////        restTemplate.delete(deleteURL);
////        System.out.println("Successfully deleted");
//    }
//
//    @Test
//    @Order(5)
//    void getAllBookings() {
//        String getAllURL = BASE_URL + "/getall";
//        System.out.println("URL: " + getAllURL);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<Booking> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//        System.out.println(response.getBody());
//    }
}