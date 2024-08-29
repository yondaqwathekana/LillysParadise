package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceImplTest {
<<<<<<< HEAD
//    @Autowired
//    private BookingService bookingService;
//    private Contact contact;
//    private Name name;
//    LocalDateTime createdDateTime = LocalDateTime.now();
//    LocalDateTime updatedDateTime = LocalDateTime.now();
//    private Room room;
//    private Guest guest;
//    private Booking booking;
//
//
//
//    @BeforeEach
//    void setUp() {
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
//    void create() {
//        Booking created = bookingService.create(booking);
//        assertNotNull(created, "Booking should not be null");
//        assertEquals(booking.getBookingId(), created.getBookingId(), "Booking ID should match");
//        System.out.println(created);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        Booking read = bookingService.read(booking.getBookingId());
//        assertNotNull(read);
//        assertEquals(booking.getBookingId(), read.getBookingId());
//        System.out.println(read);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        LocalDateTime checkout2 = LocalDateTime.parse("2024-06-10T12:30:10");
//        Booking updatedBooking = new Booking.Builder().copy(booking).setCheckOut(checkout2).build();
//        Booking updated = bookingService.update(updatedBooking);
//        assertNotNull(updated);
//        assertEquals(updatedBooking.getCheckOut(), updated.getCheckOut());
//        System.out.println("Updated");
//    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//        System.out.println(bookingService.getAll());
//    }
=======
    @Autowired
    private BookingService bookingService;
    private Contact contact;
    private Name name;
    private Room room;
    private Guest guest;
    private Booking booking;


    @BeforeEach
    void setUp() {
        contact = ContactFactory.builContact("oyo@gmail.com", "0687568765", "0784909331");
        name = NameFactory.createName("Oyola", "Zukhanye", "Mpiko");
        guest = GuestFactory.createGuest( name, contact, "password1");
        room = RoomFactory.createRoom("505", "Deluxe", 900.00, "2");
        LocalDateTime checkIn = LocalDateTime.parse("2023-05-16T12:30:10");
        LocalDateTime checkOut = LocalDateTime.parse("2023-06-10T12:30:10");
        booking = BookingFactory.createBooking("123", checkIn, checkOut, room, guest);
    }


    @Test
    @Order(1)
    void create() {
        Booking created = bookingService.create(booking);
        assertNotNull(created, "Booking should not be null");
        assertEquals(booking.getBookingId(), created.getBookingId(), "Booking ID should match");
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Booking read = bookingService.read(booking.getBookingId());
        assertNotNull(read);
        assertEquals(booking.getBookingId(), read.getBookingId());
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        LocalDateTime checkout2 = LocalDateTime.parse("2024-06-10T12:30:10");
        Booking updatedBooking = new Booking.Builder().copy(booking).setCheckOut(checkout2).build();
        Booking updated = bookingService.update(updatedBooking);
        assertNotNull(updated);
        assertEquals(updatedBooking.getCheckOut(), updated.getCheckOut());
        System.out.println("Updated");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(bookingService.getAll());
    }
>>>>>>> de01f484ca8753406fbb82313fb9641c012db813
}