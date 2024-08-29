package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminFactoryTest {
    private static Contact contact1;
    private static Name name1;
    private static Admin admin1;
    @BeforeEach
    void setUp() {
        contact1 = ContactFactory.builContact("jay@gmail.com", "0795109767", "0784909331");
        name1 = NameFactory.createName("Ongeziwe", "Jay", "Mtolo");
        admin1 = AdminFactory.buildAdmin("123", name1,contact1);
    }

    @Test
    @Order(1)
    void buildAdmin() {
        assertNotNull(admin1);
        System.out.println(admin1);
    }
}