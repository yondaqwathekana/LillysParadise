package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingFactoryTest {
<<<<<<< HEAD
//    private static Name name;
//    private static Contact contact;
//    private static Guest guest1;
//    LocalDateTime createdDateTime = LocalDateTime.now();
//    LocalDateTime updatedDateTime = LocalDateTime.now();
//    private static Room room;
//    private static LocalDateTime checkIn;
//    private static LocalDateTime checkOut;
//    private static Booking booking1;
//
//    @BeforeEach
//    void setUp() {
//        contact = ContactFactory.builContact("oyo@gmail.com", "0687568765", "0784909331");
//        name = NameFactory.createName("Oyola", "Zukhanye", "Mpiko");
//        guest1 = GuestFactory.createGuest("60005", name, contact, "password321");
//
//        UUID imageId = UUID.randomUUID();
//        String description = "Beautiful View";
//        String filePath = "/images/BnB/cover_pic1549948f.webp";
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(imageId, description, filePath, imageData, createdDateTime, updatedDateTime);
//
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image1);
//
//        room = RoomFactory.createRoom("505", "Deluxe", 900.00, "2", imageSet);
//        checkIn = LocalDateTime.parse("2024-05-16T12:30:10");
//        checkOut = LocalDateTime.parse("2024-05-26T12:30:10");
//        booking1 = BookingFactory.createBooking("1234", checkIn, checkOut, room, guest1);
//
//
//    }
//    @Test
//    void createBooking() {
//        assertNotNull(booking1);
//        assertNotNull(guest1);
//        System.out.println(booking1);
//        System.out.println(guest1);
//    }
=======
    private static Name name;
    private static Contact contact;
    private static Guest guest1;
    private static Room room;
    private static LocalDateTime checkIn;
    private static LocalDateTime checkOut;
    private static Booking booking1;

    @BeforeEach
    void setUp() {
        contact = ContactFactory.builContact("oyo@gmail.com", "0687568765", "0784909331");
        name = NameFactory.createName("Oyola", "Zukhanye", "Mpiko");
        guest1 = GuestFactory.createGuest( name, contact, "passwordr");
        room = RoomFactory.createRoom("505", "Deluxe", 900.00, "2");
        checkIn = LocalDateTime.parse("2024-05-16T12:30:10");
        checkOut = LocalDateTime.parse("2024-05-26T12:30:10");
        booking1 = BookingFactory.createBooking("1234", checkIn, checkOut, room, guest1);


    }
    @Test
    void createBooking() {
        assertNotNull(booking1);
        assertNotNull(guest1);
        System.out.println(booking1);
        System.out.println(guest1);
//        assertEquals("1234", booking1.getBookingId());
//        assertEquals(checkIn, booking1.getCheckIn());
//        assertEquals(checkOut, booking1.getCheckOut());
//        assertEquals(room, booking1.getRoom());
//        assertEquals(guest, booking1.getGuest());
    }
>>>>>>> de01f484ca8753406fbb82313fb9641c012db813
}

