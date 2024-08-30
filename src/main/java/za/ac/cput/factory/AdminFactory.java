package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin buildAdmin(String adminId, Name name, Contact contact,String password){
        if(Helper.isNullOrEmpty(adminId) || Helper.isNullOrEmpty(name.getFirstName()) ||
                Helper.isNullOrEmpty(name.getLastName()) || !Helper.isValidEmail(contact.getEmail()) ||
                Helper.isNullOrEmpty(contact.getMobile()) || Helper.isNullOrEmpty(contact.getTelephone()) || Helper.isNullOrEmpty(password))
            return null;
        return new Admin.Builder().setAdminId(adminId).setName(name).setContact(contact).setPassword(password).build();
    }
}
