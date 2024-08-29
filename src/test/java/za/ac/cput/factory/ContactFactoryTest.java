package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void builContact() {
        Contact contact1 = ContactFactory.builContact("ane@gmail.com","0876987654","08675647865");
        assertNotNull(contact1);
        System.out.println(contact1);

    }

    @Test
    void failingTest(){
        Contact contact1 = ContactFactory.builContact("ane.com", "0876987654", "08675647865");
        assertNotNull(contact1);
        System.out.println(contact1);
    }
}