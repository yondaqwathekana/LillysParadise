package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin buildAdmin(Name name, Contact contact){
        if(Helper.isNullOrEmpty(name.getFirstName()) || Helper.isNullOrEmpty(name.getLastName()) || Helper.isNullOrEmpty(contact.getMobile()) || Helper.isNullOrEmpty(contact.getTelephone()))
            return null;
        return new Admin.Builder().setName(name).setContact(contact).build();
    }
}
