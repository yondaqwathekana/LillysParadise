package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.Name;
import java.util.UUID;

public class GuestFactory {
    public static Guest createGuest(Name name, Contact contact) {
        return new Guest.Builder()
                .setName(name)
                .setContact(contact)
                .build();
    }
}
