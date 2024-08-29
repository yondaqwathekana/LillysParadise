package za.ac.cput.service;

import org.junit.jupiter.api.*;

import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.Address;
//import za.ac.cput.factory.AddressFactory;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BnbServiceImplTest {
//    LocalDateTime createdDateTime = LocalDateTime.now();
//    LocalDateTime updatedDateTime = LocalDateTime.now();
//    @Autowired
//    private BnbService service;
//
//    private Bnb bnb;
//
//    @BeforeEach
//    void setUp() {
//        // Create Images
//        UUID imageId = UUID.randomUUID();
//        String description = "Beautiful View";
//        String filePath = "/images/BnB/cover_pic1549948f.webp";
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(imageId, description, filePath, imageData, createdDateTime, updatedDateTime);
//
//        UUID imageId2 = UUID.randomUUID();
//        String description2 = "Far of Bnb View";
//        String filePath2 = "/images/BnB/cover_pic2_close_crop_cac2f91.webp";
//        byte[] imageData2 = new byte[]{1, 2, 3, 4, 5};
//        Image image2 = ImageFactory.buildImage(imageId2, description2, filePath2, imageData2, createdDateTime, updatedDateTime);
//
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image1);
//        imageSet.add(image2);
//
//        Address address = AddressFactory.buidAddress("Strand Street", "Cape Town", "8001");
//        Contact contact = ContactFactory.builContact("anelisiwen@gmail.com","0780738296","0523437363");
//
//        UUID id = UUID.randomUUID();
//        bnb = BnbFactory.buildBnb(id,"LillysParadise",imageSet,contact,address);
//    }
//
//    @Order(1)
//    @Test
//    void create() {
//
//        Bnb created = service.create(bnb);
//        assertNotNull(created);
//        System.out.println(created);
//    }
//    @Order(2)
//    @Test
//    void read() {
//        Bnb readBnB = service.read(bnb.getBnbId());
//        assertEquals(readBnB.getBnbId(), bnb.getBnbId());
////        assertNotNull(read);
//        System.out.println(readBnB);
//    }
//    @Order(3)
//    @Test
//    void update() {
//        Contact contact1 = ContactFactory.builContact("lillysBnB@gmail.com","0780738296","0523437363");
//        Bnb update = service.update(new Bnb.Builder().copy(bnb).setContact(contact1).build());
//        assertNotNull(update);
//        System.out.println(update);
//    }
//    @Order(4)
//    @Test
//    void getAll() {
//        System.out.println(service.getAll());
//    }
}