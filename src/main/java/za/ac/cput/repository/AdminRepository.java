package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;


import java.util.Set;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    Set<Admin> findAllByName_FirstNameAndName_LastName(String firstName, String lastName);
    public Admin findAdminByContact_EmailOrContact_Mobile(String emailAddress, String mobile);

    public Admin findAdminByContact_Email(String email);
    public Admin findAdminByName_FirstNameAndName_LastName(String firstName, String lastName);
    Admin findByContact(Contact contact);

    // Admin findByEmail(String email);
//    Admin findby(String email);

//    Admin findByEmail(String email);

    Admin findByContact_Email(String email);
}
