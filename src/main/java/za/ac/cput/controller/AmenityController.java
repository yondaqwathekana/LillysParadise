package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Amenity;
import za.ac.cput.service.impl.AmenityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/amenities")
public class AmenityController {
    private final AmenityServiceImpl amenityService;
    @Autowired
    public AmenityController(AmenityServiceImpl amenityService) {
        this.amenityService = amenityService;
    }
//    @PostMapping("/create")
//    public Amenity createAmenity(@RequestBody Amenity amenity){
//        return amenityService.create(amenity);
//    }
    @PostMapping("/create")
    public ResponseEntity<Amenity> createAmenity(@RequestBody Amenity amenity){
        Amenity createdAmenity = amenityService.create(amenity);
        return ResponseEntity.ok(createdAmenity);
    }
    @GetMapping("/read/{amenityId}")
    public Amenity readAmenity(@PathVariable String amenityId){
        return amenityService.read(amenityId);
    }
    @PutMapping("/update")
    public Amenity updateAmenity(@RequestBody Amenity amenity){
        return amenityService.update(amenity);
    }
    
    @GetMapping("/getall")
    public List<Amenity> getAllAmenities(){
        return amenityService.getAll();
    }

}
