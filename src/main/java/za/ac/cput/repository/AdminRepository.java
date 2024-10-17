package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;


import java.util.Set;
import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Set<Admin> findAllByName_FirstNameAndName_LastName(String firstName, String lastName);
    Admin findByContact(Contact contact);

}
