package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Bnb;

import java.util.List;
import java.util.UUID;

@Repository
public interface BnbRepository extends JpaRepository<Bnb, UUID> {
   Bnb findBnbByBnbName(String bnbName);
   Bnb findBnbByAddress_City(String city);
}
