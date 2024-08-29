package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BnbControllerTest {

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private final String BASE_URL = "http://localhost:8080/manage/bnb";
//    private static Bnb bnb;
//    private static Address address;
//    private static Contact contact;
//
//    @BeforeAll
//    public static void setUp() {
//        address = AddressFactory.buidAddress("10 Dorset","Cape Town","7234");
//        contact = ContactFactory.builContact("anelisiwentanjana@gmail.com","0623457832","0792345672");
//        // Create Images
//        byte[] imageData = new byte[]{1, 2, 3, 4, 5};
//        Image image1 = ImageFactory.buildImage(UUID.randomUUID(), "NETGEAR R9000-100NAR Nighthawk X10 AD7200", "/images/amenities/wi-fi/61zVEWrQ9BL._AC_SX466_.jpg", imageData,LocalDateTime.now(), LocalDateTime.now());
//        Image image2 = ImageFactory.buildImage(UUID.randomUUID(), "Swimming Pool", "/images/amenities/pool/cutout_of_swimming_pool_viewed_from_lunge_to_ocean439e56a.webp", imageData,LocalDateTime.now(), LocalDateTime.now());
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image1);
//        imageSet.add(image2);
//
//        bnb = BnbFactory.buildBnb(UUID.randomUUID(),"LilliesParadise",imageSet,contact,address);
//    }
//
//    @Test
//    void create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<Bnb> postResponse = restTemplate.postForEntity(url,bnb,Bnb.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        Bnb bnbSaved = postResponse.getBody();
//        assertEquals(bnb.getAddress(),bnbSaved.getAddress());
//        System.out.println(bnbSaved);
//
//    }
//
//    @Test
//    void read() {
////        String url = BASE_URL + "/read/" + bnb.getBnbId();
////        ResponseEntity<Bnb> response = restTemplate.getForEntity(url, Bnb.class);
////        assertNotNull(response);
////        assertEquals(bnb.getAddress() , response.getBody().getAddress());
////        System.out.println(response);
//    }
//
//    @Test
//    void update() {
//        String url = BASE_URL + "/update";
//        Bnb newBnb = new Bnb.Builder().copy(bnb).setBnbName("Lillies Paradise BNB").build();
//        ResponseEntity<Bnb> response = restTemplate.postForEntity(url,newBnb, Bnb.class);
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        Bnb saved = response.getBody();
//        assertEquals(newBnb.getBnbName(),saved.getBnbName());
//    }
//
//    @Test
//    void getAll() {
//        String url = BASE_URL + "/getall";
//        HttpHeaders header = new HttpHeaders();
//        HttpEntity<Address> entity = new HttpEntity<>(null, header);
//        ResponseEntity<Address> response = restTemplate.exchange(url, HttpMethod.GET,entity, Address.class);
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        System.out.println(response.getBody());
//    }
}