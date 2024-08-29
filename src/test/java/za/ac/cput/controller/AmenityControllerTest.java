package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import za.ac.cput.domain.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AmenityControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static String Base_URL = "http://localhost:8080/amenities";
    private static Amenity amenity1, amenity2, amenity3;

//    @BeforeAll
//    static void setUp() {
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(UUID.randomUUID(), "NETGEAR R9000-100NAR Nighthawk X10 AD7200", "/images/amenities/wi-fi/61zVEWrQ9BL._AC_SX466_.jpg", imageData,LocalDateTime.now(), LocalDateTime.now());
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image1);
//
//        Image image2 = ImageFactory.buildImage(UUID.randomUUID(), "Swimming Pool", "/images/amenities/pool/cutout_of_swimming_pool_viewed_from_lunge_to_ocean439e56a.webp", imageData,LocalDateTime.now(), LocalDateTime.now());
//        Set<Image> imageSet2 = new HashSet<>();
//        imageSet2.add(image2);
//
//        Image image3 = ImageFactory.buildImage(UUID.randomUUID(), "Breakfast in Bed", "/images/amenities/breakfast/breakfast_juice_fruit_cheese_nuts_crackersd10af4e.webp", imageData,LocalDateTime.now(), LocalDateTime.now());
//        Set<Image> imageSet3 = new HashSet<>();
//        imageSet3.add(image3);
//        amenity1 = AmenityFactory.createAmenity("1", "Free Wi-Fi", imageSet,"High-speed wireless internet access", true);
//        amenity2 = AmenityFactory.createAmenity("2", "Swimming Pool", imageSet2,"Outdoor swimming pool with sun loungers", true);
//        amenity3 = AmenityFactory.createAmenity("3", "Breakfast", imageSet3,"Breakfast In Bed", true);
//    }
//
//    @Test
//    @Order(1)
//    void createAmenity() {
//        String createURL = Base_URL + "/create";
//        ResponseEntity<Amenity> response1 = restTemplate.postForEntity(createURL, amenity1, Amenity.class);
//        ResponseEntity<Amenity> response2 = restTemplate.postForEntity(createURL, amenity2, Amenity.class);
//        ResponseEntity<Amenity> response3 = restTemplate.postForEntity(createURL, amenity3, Amenity.class);
//
//
//        assertNotNull(response1.getBody());
//        assertNotNull(response2.getBody());
//        assertNotNull(response3.getBody());
//
//        System.out.println(response1.getBody());
//        System.out.println(response2.getBody());
//        System.out.println(response3.getBody());
//
//    }
//
//    @Test
//    @Order(2)
//    void readAmenity() {
//        String amenityId1 = amenity2.getAmenityId();
//        String readURL = Base_URL + "/read/" + amenityId1;
//        System.out.println("URL: " + readURL);
//        ResponseEntity<Amenity> response = restTemplate.getForEntity(readURL, Amenity.class);
//        assertNotNull(response.getBody());
//        System.out.println("Read: " + response.getBody());
//    }
//
//    @Test
//    @Order(3)
//    void updateAmenity() {
////        String updateURL = Base_URL + "/update";
////        Amenity amenityUpdate = AmenityFactory.createAmenity(amenity3.getAmenityId(), "Parking", "Free on-site parking", false);
////        HttpEntity<Amenity> entity = new HttpEntity<>(amenityUpdate);
////        ResponseEntity<Amenity> response = restTemplate.exchange(updateURL, HttpMethod.PUT, entity, Amenity.class);
////        assertNotNull(response.getBody());
////        System.out.println(response.getBody());
//    }
//
//    @Test
//    @Order(4)
//    void deleteAmenity() {
//        String amenityId2 = amenity2.getAmenityId();
//        String deleteURL = Base_URL + "/delete/" + amenityId2;
//        System.out.println("URL: " + deleteURL);
//        restTemplate.delete(deleteURL);
//        System.out.println("Deleted Amenity with ID: " + amenityId2);
//    }
//
//    @Test
//    @Order(5)
//    void getAllAmenities() {
//        String getAllURL = Base_URL + "/getall";
//        System.out.println("URL: " + getAllURL);
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<Amenity> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//        System.out.println(response.getBody());
//
//    }
}