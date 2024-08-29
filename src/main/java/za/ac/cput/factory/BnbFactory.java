package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Bnb;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

import java.util.Set;
import java.util.UUID;

public class BnbFactory {
    public static Bnb buildBnb(UUID bnbId, String name, Contact contact, Address address){
        if(Helper.isNullOrEmpty(bnbId) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(contact) || Helper.isNullOrEmpty(address))
            return null;

        return new Bnb.Builder()
                .setBnbId(bnbId)
                .setBnbName(name)
                .setContact(contact)
                .setAddress(address)
                .build();
    }

}

