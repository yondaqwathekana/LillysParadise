package za.ac.cput.service;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;

import java.util.List;
import java.util.Set;

public interface AdminService extends IService<Admin, String> {
    //public void delete(String adminID);

    Admin delete(String adminId);
    Set<Admin> getAll();
    Admin findByContact(Contact contact);


    Admin findByEmail(String email);
}
