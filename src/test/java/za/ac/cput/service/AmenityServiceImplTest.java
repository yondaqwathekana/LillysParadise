package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AmenityServiceImplTest {
//    @Autowired
//    private AmenityService amenityService;
//    private Amenity amenity;
//    LocalDateTime createdDateTime = LocalDateTime.now();
//    LocalDateTime updatedDateTime = LocalDateTime.now();
//
//    @BeforeEach
//    void setUp(){
//        UUID imageId = UUID.randomUUID();
//        String description = "Beautiful View";
//        String filePath = "/images/amenity/61jIX9+d5CL._AC_SX466_.jpg";
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(imageId, description, filePath, imageData, createdDateTime, updatedDateTime);
//
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image1);
//        amenity = AmenityFactory.createAmenity("123456", "Wi-Fi", imageSet,"High-speed internet access", true);
//    }
//
//    @Test
//    @Order(1)
//    void create() {
//        Amenity createdAmenity = amenityService.create(amenity);
//        assertNotNull(createdAmenity);
//        assertEquals(amenity.getAmenityId(), createdAmenity.getAmenityId());
//        System.out.println("Created: " + createdAmenity);
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        Amenity readAmenity = amenityService.read(amenity.getAmenityId());
//        assertNotNull(readAmenity);
//        assertEquals(amenity.getAmenityId(), readAmenity.getAmenityId());
//        System.out.println("Read: " + readAmenity);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        Amenity updatedAmenity = new Amenity.Builder().copy(amenity)
//                .setName("Free Wi-Fi")
//                .build();
//        updatedAmenity = amenityService.update(updatedAmenity);
//        assertNotNull(updatedAmenity);
//        assertEquals("Free Wi-Fi", updatedAmenity.getName());
//        System.out.println("Updated: " + updatedAmenity);
//    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//        List<Amenity> amenities = amenityService.getAll();
//        assertNotNull(amenities);
//        assertFalse(amenities.isEmpty());
//        System.out.println("All Amenities: " + amenities);
//
//    }
}