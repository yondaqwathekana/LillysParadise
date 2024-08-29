package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.NameFactory;
import za.ac.cput.service.impl.AdminServiceImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminServiceImplTest {

    private final AdminServiceImpl adminService;
    @Autowired
    public AdminServiceImplTest(AdminServiceImpl adminService) { this.adminService = adminService; }

    private static Name name1, name2, name3, name4;
    private static Contact contact1, contact2, contact3, contact4;
    private static Admin admin1, admin2, admin3, admin4;

    @BeforeEach
    void setUp() {
        // admin 1
        name1 = NameFactory.createName("Luzuko", "Aphelele", "Mtolo");
        contact1 = ContactFactory.builContact("aphelele@gmail.com", "0685987654", "0219876543");
        admin1 = AdminFactory.buildAdmin("12345678", name1, contact1);
        // admin 2
        name2 = NameFactory.createName("Asanele", "King", "Kwababa");
        contact2 = ContactFactory.builContact("king@gmail.com", "0768818989", "0711622622");
        admin2 = AdminFactory.buildAdmin("87654321", name2, contact2);
        // admin 3
        name3 = NameFactory.createName("John", "Cain", "Smith");
        contact3 = ContactFactory.builContact("johnsmith@gmail.com", "0698765432", "0754765432");
        admin3 = AdminFactory.buildAdmin("10000001", name3, contact3);
        // admin4
        name4 = NameFactory.createName("Okuhle", "Slish", "Semane");
        contact4 = ContactFactory.builContact("okuhle@gmail.com", "0865436754", "0987654321");
        admin4 = AdminFactory.buildAdmin("76859658", name4, contact4);
    }

    @Test
    @Order(1)
    void create() {
        Admin createdAdmin1 = adminService.create(admin1);
        Admin createdAdmin2 = adminService.create(admin2);
        Admin createdAdmin3 = adminService.create(admin3);
        Admin createdAdmin4 = adminService.create(admin4);
        assertNotNull(createdAdmin1);
        assertNotNull(createdAdmin2);
        assertNotNull(createdAdmin3);
        assertNotNull(createdAdmin4);
        System.out.println(createdAdmin1);
        System.out.println(createdAdmin2);
        System.out.println(createdAdmin3);
        System.out.println(createdAdmin4);
    }

    @Test
    @Order(2)
    void read() {
        Admin readAdmin2 = adminService.read("87654321");
        assertNotNull(readAdmin2);
        System.out.println(readAdmin2);
    }

    @Test
    @Order(3)
    void update() {
        Name name1MiddleNameUpdate = NameFactory.createName("Luzuko", "Ayanda", "Mtolo");
        Admin updatedAdmin = adminService.update(new Admin.Builder().copy(admin1).setName(name1MiddleNameUpdate).build());
        assertNotNull(updatedAdmin);
        System.out.println(updatedAdmin);
    }

    @Test
    @Order(5)
    void delete() {
        Admin adminToDelete = adminService.read(admin3.getAdminId());
        if(adminToDelete != null) adminService.delete(adminToDelete.getAdminId());
    }

    @Test
    @Order(4)
    void getAll() {
        Set<Admin> getAll = adminService.getAll();
        assertNotNull(getAll);
        System.out.println(getAll);
    }
}