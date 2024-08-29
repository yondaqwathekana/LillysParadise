package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Amenity;
import za.ac.cput.repository.AmenityRepository;
import za.ac.cput.service.AmenityService;

import java.util.List;

@Service
public class AmenityServiceImpl  implements AmenityService {
    private final AmenityRepository amenityRepository;

    @Autowired
    public AmenityServiceImpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @Override
    public Amenity create(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    public Amenity read(String s) {
        return amenityRepository.findById(s).orElse(null);
    }

    @Override
    public Amenity update(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    public List<Amenity> getAll() {
        return amenityRepository.findAll();
}

}
