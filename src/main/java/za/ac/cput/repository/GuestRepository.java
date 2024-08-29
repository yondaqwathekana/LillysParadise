package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Name;

import java.util.UUID;

@Repository
public interface GuestRepository extends JpaRepository<Guest, UUID> {
    public Guest findGuestByContact_Email(String email);
    public Guest findGuestByName_FirstNameAndName_LastName(String firstName, String lastName);
    Guest findByContact(Contact contact);
}
