package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.impl.PaymentServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.domain.enums.PaymentMethod.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceImplTest {

<<<<<<< HEAD
//    private final PaymentServiceImpl paymentService;
//    @Autowired
//    public PaymentServiceImplTest(PaymentServiceImpl paymentService) {
//        this.paymentService = paymentService;
//    }
//    private static Contact contact1, contact2;
//    private static Name name1, name2;
//    private static Guest guest1, guest2;
//    LocalDateTime createdDateTime = LocalDateTime.now();
//    LocalDateTime updatedDateTime = LocalDateTime.now();
//    private static Room room1, room2;
//    private static Booking booking1, booking2;
//    private static Payment payment1, payment2;
//
//    @BeforeEach
//    void setUp() {
//        // payment 1
//        contact1 = ContactFactory.builContact("jay@gmail.com", "0795109767", "0784909331");
//        name1 = NameFactory.createName("Junior", "Ongeziwe", "Mtolo");
//        guest1 = GuestFactory.createGuest("10001",name1, contact1, "12345");
//
//        UUID imageId = UUID.randomUUID();
//        String description = "Beautiful View";
//        String filePath = "/images/room/ups_mount_img_0121a4d3ec9.webp";
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(imageId, description, filePath, imageData, createdDateTime, updatedDateTime);
//        Set<Image> imageSet1 = new HashSet<>();
//        imageSet1.add(image1);
//
//        room1 = RoomFactory.createRoom("C619", "2Bedroom", 5000.00,"6thFloor", imageSet1);
//        LocalDateTime checkIn = LocalDateTime.parse("2023-05-16T12:30:10");
//        LocalDateTime checkOut = LocalDateTime.parse("2023-06-10T12:30:10");
//        booking1 = BookingFactory.createBooking("#001", checkIn, checkOut, room1, guest1);
//        LocalDate paymentDate = LocalDate.parse("2023-05-13");
//        LocalTime paymentTime = LocalTime.parse("12:30");
//        payment1 = PaymentFactory.buildPayment("123", booking1, SAMSUNG_PAY, paymentDate, paymentTime);
//        // payment 2
//        contact2 = ContactFactory.builContact("yonda@gmail.com", "0687896547", "0823356789");
//        name2 = NameFactory.createName("Yonda", "Luyanda","Qwathekana");
//        guest2 = GuestFactory.createGuest("20002",name2, contact2, "09876");
//
//        UUID imageId2 = UUID.randomUUID();
//        String description2 = "Far of Bnb View";
//        String filePath2 = "/images/room/dwns_ocean_img_3138_nova9d40b0.webp";
//        byte[] imageData2 = new byte[]{1, 2, 3, 4, 5};
//        Image image2 = ImageFactory.buildImage(imageId2, description2, filePath2, imageData2, createdDateTime, updatedDateTime);
//        Set<Image> imageSet2 = new HashSet<>();
//        imageSet2.add(image2);
//
//        room2 = RoomFactory.createRoom("202", "Standard", 900.00, "2", imageSet2);
//        LocalDateTime checkIn1 = LocalDateTime.parse("2024-06-16T12:30:10");
//        LocalDateTime checkOut1 = LocalDateTime.parse("2024-06-20T12:30:10");
//        booking2 = BookingFactory.createBooking("#002", checkIn1, checkOut1, room2, guest2);
//        LocalDate paymentDate1 = LocalDate.parse("2023-04-13");
//        LocalTime paymentTime1 = LocalTime.parse("10:30");
//        payment2 = PaymentFactory.buildPayment("456", booking2, CREDIT_CARD, paymentDate1, paymentTime1);
//    }
//
//    @Test
//    @Order(1)
//    void create() {
//        Payment createdPayment = paymentService.create(payment1);
//        Payment createdPayment2 = paymentService.create(payment2);
//        assertNotNull(createdPayment);
//        assertNotNull(createdPayment2);
//        System.out.println(createdPayment);
//        System.out.println(createdPayment2);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        Payment readPayment = paymentService.read("456");
//        assertNotNull(readPayment);
//        System.out.println(readPayment);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        Payment updatePayment1 = paymentService.update(new Payment.Builder().copy(payment1).setPaymentMethod(PAY_PAL).build());
//        assertNotNull(updatePayment1);
//        System.out.println(updatePayment1);
//    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//        Set<Payment> getPayments = paymentService.getAll();
//        assertNotNull(getPayments);
//        System.out.println(getPayments);
//    }
=======
    private final PaymentServiceImpl paymentService;
    @Autowired
    public PaymentServiceImplTest(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }
    private static Contact contact1, contact2;
    private static Name name1, name2;
    private static Guest guest1, guest2;
    private static Room room1, room2;
    private static Booking booking1, booking2;
    private static Payment payment1, payment2;

    @BeforeEach
    void setUp() {
        // payment 1
        contact1 = ContactFactory.builContact("jay@gmail.com", "0795109767", "0784909331");
        name1 = NameFactory.createName("Junior", "Ongeziwe", "Mtolo");
        guest1 = GuestFactory.createGuest(name1, contact1, "12345");
        room1 = RoomFactory.createRoom("101", "Deluxe", 1000.00, "1");
        LocalDateTime checkIn = LocalDateTime.parse("2023-05-16T12:30:10");
        LocalDateTime checkOut = LocalDateTime.parse("2023-06-10T12:30:10");
        booking1 = BookingFactory.createBooking("#001", checkIn, checkOut, room1, guest1);
        LocalDate paymentDate = LocalDate.parse("2023-05-13");
        LocalTime paymentTime = LocalTime.parse("12:30");
        payment1 = PaymentFactory.buildPayment("123", booking1, SAMSUNG_PAY, paymentDate, paymentTime);
        // payment 2
        contact2 = ContactFactory.builContact("yonda@gmail.com", "0687896547", "0823356789");
        name2 = NameFactory.createName("Yonda", "Luyanda","Qwathekana");
        guest2 = GuestFactory.createGuest(name2, contact2, "09876");
        room2 = RoomFactory.createRoom("202", "Standard", 900.00, "2");
        LocalDateTime checkIn1 = LocalDateTime.parse("2024-06-16T12:30:10");
        LocalDateTime checkOut1 = LocalDateTime.parse("2024-06-20T12:30:10");
        booking2 = BookingFactory.createBooking("#002", checkIn1, checkOut1, room2, guest2);
        LocalDate paymentDate1 = LocalDate.parse("2023-04-13");
        LocalTime paymentTime1 = LocalTime.parse("10:30");
        payment2 = PaymentFactory.buildPayment("456", booking2, CREDIT_CARD, paymentDate1, paymentTime1);
    }

    @Test
    @Order(1)
    void create() {
        Payment createdPayment = paymentService.create(payment1);
        Payment createdPayment2 = paymentService.create(payment2);
        assertNotNull(createdPayment);
        assertNotNull(createdPayment2);
        System.out.println(createdPayment);
        System.out.println(createdPayment2);
    }

    @Test
    @Order(2)
    void read() {
        Payment readPayment = paymentService.read("456");
        assertNotNull(readPayment);
        System.out.println(readPayment);
    }

    @Test
    @Order(3)
    void update() {
        Payment updatePayment1 = paymentService.update(new Payment.Builder().copy(payment1).setPaymentMethod(PAY_PAL).build());
        assertNotNull(updatePayment1);
        System.out.println(updatePayment1);
    }

    @Test
    @Order(4)
    void getAll() {
        Set<Payment> getPayments = paymentService.getAll();
        assertNotNull(getPayments);
        System.out.println(getPayments);
    }
>>>>>>> de01f484ca8753406fbb82313fb9641c012db813
}