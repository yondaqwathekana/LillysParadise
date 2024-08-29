package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;



class NameFactoryTest {
    private static Name name;

    @BeforeEach
    void setUp() {
        name = NameFactory.createName("Esihle", "Rosey","Soxokashe");


    }

    @Test
    void createName() {
        assertNotNull(name);
        System.out.println(name);
    }
}