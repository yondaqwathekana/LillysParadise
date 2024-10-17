package za.ac.cput.service;

import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Guest;
import za.ac.cput.dto.RegisterUserDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface AdminService extends IService<Admin, UUID> {
    //public void delete(String adminID);
    Admin createAdminFromDto(RegisterUserDto dto);
    Admin delete(UUID adminId);
    Set<Admin> getAll();
    Admin findByContact(Contact contact);

}
