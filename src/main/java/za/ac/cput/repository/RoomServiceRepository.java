package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Room;
import za.ac.cput.domain.RoomService;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomService, String> {
    public RoomService findByServiceName(String ServiceName);

}
