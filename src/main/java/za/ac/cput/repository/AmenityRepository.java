package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Amenity;
@Repository
public interface AmenityRepository extends JpaRepository<Amenity, String> {
    Amenity findAmenityByName(String name);
}
