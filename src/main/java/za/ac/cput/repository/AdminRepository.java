package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;

import java.util.Set;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    Set<Admin> findAllByName_FirstNameAndName_LastName(String firstName, String lastName);
    public Admin findAdminByContact_EmailOrContact_Mobile(String emailAddress, String mobile);
}
