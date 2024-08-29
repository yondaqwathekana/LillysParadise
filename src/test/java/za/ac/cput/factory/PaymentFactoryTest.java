package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.domain.enums.PaymentMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.domain.enums.PaymentMethod.GOOGLE_PAY;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentFactoryTest {
    private static Name name;
    private static Contact contact;
    private static Guest guest;
    private static Room room;
    private static Booking booking;
    private static Payment payment;

    @BeforeEach
    void setUp() {
        contact = new Contact.Builder().setEmail("jay@gmail.com").setMobile("0795109767").setTelephone("0784909331").build();
        name = new Name.Builder().setFirstName("Ongeziwe").setMiddleName("Jay").setLastName("Mtolo").build();
        guest = new Guest.Builder().setName(name).setContact(contact).build();
        room = new Room.Builder().setRoomNumber("101").setRoomType("Deluxe").setRoomFloor("2").setRoomPrice(900.00).build();
        LocalDateTime checkIn = LocalDateTime.parse("2023-05-16T12:30:10");
        LocalDateTime checkOut = LocalDateTime.parse("2023-06-10T12:30:10");
        booking = new Booking.Builder().setBookingId("123").setCheckIn(checkIn).setCheckOut(checkOut).setRoom(room).setGuest(guest).build();

    }

    @Test
    @Order(1)
    void buildPayment() {
        LocalDate paymentDate = LocalDate.parse("2023-05-13");
        LocalTime paymentTime = LocalTime.parse("12:30:10");
        payment = PaymentFactory.buildPayment("123", booking, GOOGLE_PAY, paymentDate, paymentTime);

        assertNotNull(payment);
        System.out.println(payment);
    }
}