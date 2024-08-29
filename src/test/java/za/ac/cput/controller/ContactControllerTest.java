package za.ac.cput.controller;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String  BASE_URL = "http://localhost:8080/manage/contact";
    private static Contact contact;

    @BeforeAll
    public static  void setUp(){
        contact = ContactFactory.builContact("anelisiwentanjana@gmail.com","0623457832","0792345672");
    }

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact,Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Contact created = postResponse.getBody();
        assertEquals(contact.getEmail() , created.getEmail());
        System.out.println(created);

    }

    @Test
    void read() {
        String url = BASE_URL + "/read" + contact.getEmail();
        ResponseEntity<Contact> response = restTemplate.getForEntity(url, Contact.class);
        assertEquals(contact.getEmail(), response.getBody().getEmail());
        System.out.println(response);
    }

    @Test
    void update() {
        String url = BASE_URL + "/update";
        Contact newContact = new Contact.Builder().copy(contact).setMobile("0632345725").build();
        ResponseEntity<Contact> updateContact = restTemplate.postForEntity(url, newContact, Contact.class);
        assertNotNull(updateContact);
        assertNotNull(updateContact.getBody());
        Contact saved = updateContact.getBody();
        assertEquals(newContact.getEmail(),saved.getEmail());
        System.out.println(saved);
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null , headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}