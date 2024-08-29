package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.AdminFactory;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.NameFactory;

import java.lang.reflect.ParameterizedType;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static String Base_URL = "http://localhost:8080/manage/admins";
    private static Name name1, name2, name3, name4;
    private static Contact contact1, contact2, contact3, contact4;
    private static Admin admin1, admin2, admin3, admin4;
    @BeforeAll
    static void setUp() {
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
    void createAdmin() {
        String createURL = Base_URL + "/create";
        System.out.println("URL: " + createURL);
        ResponseEntity<Admin> response1 = restTemplate.postForEntity(createURL, admin1, Admin.class);
        ResponseEntity<Admin> response2 = restTemplate.postForEntity(createURL, admin2, Admin.class);
        ResponseEntity<Admin> response3 = restTemplate.postForEntity(createURL, admin3, Admin.class);
        ResponseEntity<Admin> response4 = restTemplate.postForEntity(createURL, admin4, Admin.class);
        assertNotNull(response1.getBody());
        assertNotNull(response2.getBody());
        assertNotNull(response3.getBody());
        assertNotNull(response4.getBody());
        System.out.println(response1.getBody());
        System.out.println(response2.getBody());
        System.out.println(response3.getBody());
        System.out.println(response4.getBody());
    }

    @Test
    @Order(2)
    void readAdmin() {
        String admin2_Id = admin2.getAdminId();
        String readURL = Base_URL + "/read/" + admin2_Id;
        System.out.println("URL: " + readURL);
        ResponseEntity<Admin> response1 = restTemplate.getForEntity(readURL, Admin.class);
        assertNotNull(response1.getBody());
        System.out.println("Read: " + response1.getBody());
    }

    @Test
    @Order(3)
    void updateAdmin() {
        String updateURL = Base_URL + "/update";
        System.out.println("URL: " + updateURL);
        Name nameUpdate = new Name.Builder().copy(name4).setMiddleName("Silindo").build();
        Contact contactUpdate = new Contact.Builder().copy(contact4).setTelephone("0876541234").build();
        Admin adminUpdate = AdminFactory.buildAdmin(admin4.getAdminId(), nameUpdate, contactUpdate);
        assert adminUpdate != null;
        HttpEntity<Admin> entity = new HttpEntity<>(adminUpdate);
        ResponseEntity<Admin> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Admin.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    @Order(6)
    void deleteAdmin() {
        String admin_Id = admin3.getAdminId();
        String deleteURL = Base_URL + "/delete/" + admin_Id;
        System.out.println("URL: " + deleteURL);
        restTemplate.delete(deleteURL);
        System.out.println("Deleted Employee");
    }

    @Test
    @Order(4)
    void getAllAdmins() {
        String getAllURL = Base_URL + "/getall";
        System.out.println("URL: " + getAllURL);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Admin> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(5)
    void getByFirstNameAndLastName() {
        String firstName = admin1.getName().getFirstName();
        String lastName = admin1.getName().getLastName();
        String searchURL = Base_URL + "/search?firstName=" + firstName + "&lastName=" + lastName;
        System.out.println("URL: " + searchURL);
        ResponseEntity<Set<Admin>> response = restTemplate.exchange(searchURL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        assertNotNull(response.getBody());
        System.out.println("Search Results: " + response.getBody());
    }
}