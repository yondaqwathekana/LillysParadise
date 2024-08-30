package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Room;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    Optional<Room> findRoomByImageName(String imageName);
    Set<Room> findRoomByRoomType(String roomType);
}
