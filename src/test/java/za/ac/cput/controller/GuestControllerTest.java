package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Guest;
import za.ac.cput.request.LoginRequest;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.GuestFactory;
import za.ac.cput.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GuestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/guest"; // Remove base URL part as TestRestTemplate handles it

    private static Guest guest1;

    @BeforeAll
    static void setUp(@Autowired TestRestTemplate restTemplate) {
        // Setup guest 1
        var contact1 = ContactFactory.builContact("ntanjane@gmail.com", "0670608443", "070608443");
        var name1 = NameFactory.createName("Noma", "Tanjane", "Sibisi");
        guest1 = GuestFactory.createGuest(name1, contact1, "ntanjane@gmail.com");

        // Create guest 1 using the API
        String createURL = BASE_URL + "/create";
        HttpEntity<Guest> createRequest = new HttpEntity<>(guest1);
        ResponseEntity<Guest> response = restTemplate.postForEntity(createURL, createRequest, Guest.class);

        assertNotNull(response.getBody(), "Response body should not be null");
        guest1 = response.getBody();
    }

    @Test
    @Order(1)
    void loginGuest() {
        String loginURL = BASE_URL + "/login";
        System.out.println("URL: " + loginURL);

        // Prepare login request with correct credentials
        LoginRequest correctRequest = new LoginRequest();
        correctRequest.setEmail("ntanjane@gmail.com");
        correctRequest.setPassword("ntanjane@gmail.com");

        // Send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(loginURL, correctRequest, String.class);

        // Verify response
        assertEquals(200, response.getStatusCodeValue(), "Login should be successful");
        assertEquals("Login successful", response.getBody(), "Response body should indicate successful login");

        System.out.println("Login successful with correct credentials");

        // Test with incorrect credentials
        LoginRequest incorrectRequest = new LoginRequest();
        incorrectRequest.setEmail("ntanjane@gmail.com");
        incorrectRequest.setPassword("wrongpass");

        ResponseEntity<String> responseIncorrect = restTemplate.postForEntity(loginURL, incorrectRequest, String.class);

        // Verify response for incorrect credentials
        assertEquals(401, responseIncorrect.getStatusCodeValue(), "Login should fail with incorrect credentials");
        assertEquals("Invalid email or password", responseIncorrect.getBody(), "Response body should indicate invalid credentials");

        System.out.println("Login failed with incorrect credentials");
    }
}
