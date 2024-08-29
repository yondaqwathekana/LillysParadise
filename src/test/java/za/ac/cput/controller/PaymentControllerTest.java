package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.*;
import za.ac.cput.domain.enums.PaymentMethod;
import za.ac.cput.factory.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentControllerTest {
<<<<<<< HEAD
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private static String Base_URL = "http://localhost:8080/manage/payments";
//
//    private Payment payment1, payment2;
//    LocalDateTime createdDateTime = LocalDateTime.now();
//    LocalDateTime updatedDateTime = LocalDateTime.now();
//
//    @BeforeEach
//    void setUp() {
//        // payment 1
//        Name name1 = NameFactory.createName("Ongeziwe", "Junior", "Mtolo");
//        Contact contact1 = ContactFactory.builContact("junior@gmail.com", "0795109767", "0784909331");
//        assert name1 != null;
//        Guest guest1 = GuestFactory.createGuest("10001",name1, contact1, "12345676");
//        // Create Images
//        UUID imageId = UUID.randomUUID();
//        String description = "Beautiful View";
//        String filePath = "/images/room/ups_mount_img_0121a4d3ec9.webp";
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(imageId, description, filePath, imageData, createdDateTime, updatedDateTime);
//        Set<Image> imageSet1 = new HashSet<>();
//        imageSet1.add(image1);
//
//        UUID imageId2 = UUID.randomUUID();
//        String description2 = "Far of Bnb View";
//        String filePath2 = "/images/room/dwns_ocean_img_3138_nova9d40b0.webp";
//        byte[] imageData2 = new byte[]{1, 2, 3, 4, 5};
//        Image image2 = ImageFactory.buildImage(imageId2, description2, filePath2, imageData2, createdDateTime, updatedDateTime);
//        Set<Image> imageSet2 = new HashSet<>();
//        imageSet2.add(image2);
//
//        Room room1 = RoomFactory.createRoom("002", "Deluxe", 900.00, "Ground Floor", imageSet1);
//        LocalDateTime checkIn = LocalDateTime.of(2024, 5, 13, 14, 0);
//        LocalDateTime checkOut = LocalDateTime.of(2024, 5, 20, 11, 30);
//        Booking booking1 = BookingFactory.createBooking("#101", checkIn, checkOut, room1, guest1);
//        LocalDate paymentDate = LocalDate.of(2024, 5, 10);
//        LocalTime paymentTime = LocalTime.of(15,30);
//        payment1 = PaymentFactory.buildPayment("#675165871558795", booking1, PaymentMethod.SAMSUNG_PAY, paymentDate, paymentTime);
//
//
//        // payment 2
//        Name name2 = new Name.Builder().setFirstName("Aphelele").setMiddleName("Luzuko").setLastName("Kwababa").build();
//        Contact contact2 = new Contact.Builder().setEmail("luzuko@gmail.com").setMobile("0687654789").setTelephone("0768818989").build();
//        Guest guest2 = new Guest.Builder().setName(name2).setContact(contact2).setPassword("111111").build();
//        Room room2 = RoomFactory.createRoom("002", "Deluxe", 900.00, "Ground Floor", imageSet2);
//        LocalDateTime checkIn2 = LocalDateTime.of(2024, 5, 13, 14, 0);
//        LocalDateTime checkOut2 = LocalDateTime.of(2024, 5, 20, 11, 30);
//        Booking booking2 = new Booking.Builder().setBookingId("#102").setCheckIn(checkIn2).setCheckOut(checkOut2).setRoom(room2).setGuest(guest2).build();
//        LocalDate paymentDate2 = LocalDate.of(2024, 5, 10);
//        LocalTime paymentTime2 = LocalTime.of(15,30);
//        payment2 = new Payment.Builder().setPaymentId("#78157485981656").setBooking(booking2).setPaymentMethod(PaymentMethod.GOOGLE_PAY).setDate(paymentDate2).setTime(paymentTime2).build();
//    }
//
//    @Test
//    @Order(1)
//    void createPayment() {
//        String createURL = Base_URL + "/create";
//        System.out.println("createURL: " + createURL);
//        ResponseEntity<Payment> response1 = restTemplate.postForEntity(createURL, payment1, Payment.class);
//        ResponseEntity<Payment> response2 = restTemplate.postForEntity(createURL, payment2, Payment.class);
//        assertNotNull(response1);
//        assertNotNull(response2);
//        System.out.println("Created Payment: " + response1.getBody());
//        System.out.println("Created Payment: " + response2.getBody());
//    }
//
//    @Test
//    @Order(2)
//    void readPayment() {
//        String paymentId = payment1.getPaymentId();
//        String readURL = Base_URL + "/read/" + paymentId;
//        System.out.println("URL: " + readURL);
//        ResponseEntity<Payment> response = restTemplate.getForEntity(readURL, Payment.class);
//        assertNotNull(response);
//        System.out.println(response.getBody());
//    }
//
//    @Test
//    @Order(3)
//    void updatePayment() {
//        String updateURL = Base_URL + "/update";
//        System.out.println(updateURL);
//        Payment updatedPayment = new Payment.Builder().copy(payment2).setPaymentMethod(PaymentMethod.SAMSUNG_PAY).build();
//        HttpEntity<Payment> entity = new HttpEntity<>(updatedPayment);
//        ResponseEntity<Payment> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Payment.class);
//        assertNotNull(response);
//        System.out.println(response.getBody());
//    }
//
//    @Test
//    @Order(4)
//    void getAllPayments() {
//        String getAllPaymentsURL = Base_URL + "/getallpayements";
//        System.out.println("URL: " + getAllPaymentsURL);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<Payment> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getAllPaymentsURL, HttpMethod.GET, entity, String.class);
//        assertNotNull(response);
//        System.out.println("URL: " + response.getBody());
//    }
}
=======

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/manage/payments";

    private Payment payment1, payment2;

    @BeforeEach
    void setUp() {
        // payment 1
        Name name1 = NameFactory.createName("Ongeziwe", "Junior", "Mtolo");
        Contact contact1 = ContactFactory.builContact("junior@gmail.com", "0795109767", "0784909331");
        assert name1 != null;
        Guest guest1 = GuestFactory.createGuest(name1, contact1, "12345676");
        Room room1 = RoomFactory.createRoom("002", "Deluxe", 900.00, "Ground Floor");
        LocalDateTime checkIn = LocalDateTime.of(2024, 5, 13, 14, 0);
        LocalDateTime checkOut = LocalDateTime.of(2024, 5, 20, 11, 30);
        Booking booking1 = BookingFactory.createBooking("#101", checkIn, checkOut, room1, guest1);
        LocalDate paymentDate = LocalDate.of(2024, 5, 10);
        LocalTime paymentTime = LocalTime.of(15, 30);
        payment1 = PaymentFactory.buildPayment("#675165871558795", booking1, PaymentMethod.SAMSUNG_PAY, paymentDate, paymentTime);

        // payment 2
        Name name2 = NameFactory.createName("Aphelele", "Luzuko", "Kwababa");
        Contact contact2 = ContactFactory.builContact("luzuko@gmail.com", "0687654789", "0768818989");
        Guest guest2 = GuestFactory.createGuest(name2, contact2, "111111");
        Room room2 = RoomFactory.createRoom("102", "Standard", 850.00, "1st Floor");
        LocalDateTime checkIn2 = LocalDateTime.of(2024, 5, 13, 14, 0);
        LocalDateTime checkOut2 = LocalDateTime.of(2024, 5, 20, 11, 30);
        Booking booking2 = BookingFactory.createBooking("#102", checkIn2, checkOut2, room2, guest2);
        LocalDate paymentDate2 = LocalDate.of(2024, 5, 10);
        LocalTime paymentTime2 = LocalTime.of(15, 30);
        payment2 = PaymentFactory.buildPayment("#78157485981656", booking2, PaymentMethod.GOOGLE_PAY, paymentDate2, paymentTime2);
    }

    @Test
    @Order(1)
    void createPayment() {
        String createURL = BASE_URL + "/create";
        System.out.println("createURL: " + createURL);

        ResponseEntity<Payment> response1 = restTemplate.postForEntity(createURL, payment1, Payment.class);
        assertNotNull(response1.getBody(), "Response body for payment1 should not be null");
        assertEquals(HttpStatus.OK, response1.getStatusCode(), "Expected status code 200 OK");

        ResponseEntity<Payment> response2 = restTemplate.postForEntity(createURL, payment2, Payment.class);
        assertNotNull(response2.getBody(), "Response body for payment2 should not be null");
        assertEquals(HttpStatus.OK, response2.getStatusCode(), "Expected status code 200 OK");

        // Update the payment objects with the IDs returned from the server
        payment1 = response1.getBody();
        payment2 = response2.getBody();

        System.out.println("Created Payment 1: " + response1.getBody());
        System.out.println("Created Payment 2: " + response2.getBody());
    }

    @Test
    @Order(2)
    void readPayment() {
        String paymentId = payment1.getPaymentId();
        String readURL = BASE_URL + "/read/" + paymentId;
        System.out.println("URL: " + readURL);

        ResponseEntity<Payment> response = restTemplate.getForEntity(readURL, Payment.class);
        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code 200 OK");
        assertEquals(payment1.getPaymentId(), response.getBody().getPaymentId(), "Payment IDs should match");

        System.out.println("Read Payment: " + response.getBody());
    }

    @Test
    @Order(3)
    void updatePayment() {
        String updateURL = BASE_URL + "/update";
        System.out.println("Update URL: " + updateURL);

        Payment updatedPayment = new Payment.Builder()
                .copy(payment2)
                .setPaymentMethod(PaymentMethod.SAMSUNG_PAY)
                .build();

        HttpEntity<Payment> entity = new HttpEntity<>(updatedPayment);
        ResponseEntity<Payment> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Payment.class);

        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code 200 OK");
        assertEquals(PaymentMethod.SAMSUNG_PAY, response.getBody().getPaymentMethod(), "Payment method should be updated to SAMSUNG_PAY");

        System.out.println("Updated Payment: " + response.getBody());
    }

    @Test
    @Order(4)
    void getAllPayments() {
        String getAllPaymentsURL = BASE_URL + "/getall";
        System.out.println("Get All Payments URL: " + getAllPaymentsURL);

        ResponseEntity<Payment[]> response = restTemplate.getForEntity(getAllPaymentsURL, Payment[].class);

        assertNotNull(response.getBody(), "Response body should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected status code 200 OK");
        assertTrue(response.getBody().length > 0, "There should be at least one payment");

        System.out.println("All Payments: ");
        for (Payment payment : response.getBody()) {
            System.out.println(payment);
        }
    }

    @Test
    @Order(5)
    void deletePayment() {
        String paymentId = payment2.getPaymentId();
        String deleteURL = BASE_URL + "/delete/" + paymentId;
        System.out.println("Delete URL: " + deleteURL);

        restTemplate.delete(deleteURL);

        // Verify deletion
        ResponseEntity<Payment> response = restTemplate.getForEntity(BASE_URL + "/read/" + paymentId, Payment.class);
        assertNull(response.getBody(), "Payment should be deleted");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Expected status code 404 NOT FOUND after deletion");

        System.out.println("Deleted Payment");
    }
}
>>>>>>> de01f484ca8753406fbb82313fb9641c012db813
