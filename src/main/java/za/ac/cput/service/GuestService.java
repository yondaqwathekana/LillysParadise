package za.ac.cput.service;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Name;

import java.util.List;

public interface GuestService extends IService<Guest, String> {
    Guest findByContact(Contact contact);

    List<Guest> getAll();
    Guest findByEmail(String email);
}
