package za.ac.cput.service;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceImplTest {
    @Autowired
    private ContactService service;

    Contact contact = ContactFactory.builContact("anelisiwen@gmail.com","0623469734","0473457474");

    @Order(1)
    @Test
    void create() {
        Contact created = service.create(contact);
        assertNotNull(contact);
        System.out.println(contact);
    }
    @Order(2)
    @Test
    void read() {
        Contact read = service.read(contact.getEmail());
        assertNotNull(read);
        System.out.println(read);
    }

    @Order(3)
    @Test
    void update() {
        Contact update = service.update(new Contact.Builder().copy(contact).setMobile("0780935748").build());
        assertNotNull(update);
        System.out.println(update);
    }
    @Order(4)
    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}