package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Name;
import java.util.UUID;

public class GuestFactory {
    public static Guest createGuest(Name name, Contact contact, String password) {
        UUID guestId = UUID.randomUUID();  // Generate a random UUID
        return new Guest.Builder()
                .setGuest_id(guestId)
                .setName(name)
                .setContact(contact)
                .setPassword(password)
                .build();
    }
}
