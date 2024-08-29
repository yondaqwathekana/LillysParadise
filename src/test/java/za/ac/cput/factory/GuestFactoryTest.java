package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class GuestFactoryTest {
    private static Name name;
    private static Contact contact;
    private static Guest guest1;
    @BeforeEach
    void setUp() {
        contact = ContactFactory.builContact("esihlerosey@gmail.com", "0670608443", "98655236");
        name = NameFactory.createName("Esihle", "Rosey", "Soxokashe");
        guest1 = GuestFactory.createGuest(name, contact, "password");
    }

    @Test
    void createGuest() {
        assertNotNull(guest1);
        System.out.println(guest1);
    }
}