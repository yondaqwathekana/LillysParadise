package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.GuestFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.impl.GuestServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GuestServiceImplTest {

    @Autowired
    private GuestServiceImpl guestService;

    private Name name;
    private Contact contact;
    private Guest guest;

    @BeforeEach
    void setUp() {
        name = NameFactory.createName("Esihle", "Rosey", "Soxokashe");
        contact = ContactFactory.builContact("esihler@gmail.com", "0782345792", "0456782345");
        guest = GuestFactory.createGuest(name, contact, "password123");
    }

    @Test
    void create() {
        Guest created = guestService.create(guest);
        assertNotNull(created);
        assertEquals(guest.getName(), created.getName());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Guest created = guestService.create(guest);
        assertNotNull(created);

        Guest read = guestService.read(created.getIdAsString());  // Convert UUID to String
        assertNotNull(read);
        assertEquals(created.getIdAsString(), read.getIdAsString());  // Compare as Strings
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Guest created = guestService.create(guest);
        assertNotNull(created);

        Name newName = NameFactory.createName("UpdatedFirstName", "UpdatedMiddleName", "UpdatedLastName");
        Guest updatedGuest = new Guest.Builder().copy(created).setName(newName).build();

        Guest updated = guestService.update(updatedGuest);
        assertNotNull(updated);
        assertEquals(newName, updated.getName());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        Guest created = guestService.create(guest);
        assertNotNull(created);



        Guest deleted = guestService.read(created.getIdAsString());  // Convert UUID to String
        assertNull(deleted);
        System.out.println("Deleted Guest ID: " + created.getIdAsString());  // Convert UUID to String
    }
}
