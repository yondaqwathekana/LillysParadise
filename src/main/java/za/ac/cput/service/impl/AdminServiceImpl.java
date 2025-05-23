package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Name;
import za.ac.cput.dto.RegisterUserDto;
import za.ac.cput.repository.AdminRepository;
import za.ac.cput.service.AdminService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;
    @Autowired
    public AdminServiceImpl(AdminRepository repository) { this.repository = repository; }

    @Override
    public Admin create(Admin admin) { return repository.save(admin); }
    @Override
    public Admin read(UUID adminId) { return repository.findById(adminId).orElseThrow(()-> new NoSuchElementException("No admin with such email address exist")); }
    @Override
    public Admin update(Admin admin) { return repository.save(admin); }

    @Override
    public Admin createAdminFromDto(RegisterUserDto dto) {
        Name name = new Name.Builder()
                .setFirstName(dto.getName().getFirstName())
                .setMiddleName(dto.getName().getMiddleName())
                .setLastName(dto.getName().getLastName())
                .build();

        Contact contact = new Contact.Builder()
                .setTelephone(dto.getContact().getTelephone())
                .setMobile(dto.getContact().getMobile())
                .build();

        Admin admin = new Admin(name, contact, dto.getEmail(), dto.getPassword());
        return repository.save(admin);
    }

    @Override
    public Admin delete(UUID adminId) {
        Admin adminToDelete = read(adminId);
        repository.delete(adminToDelete);
        return  adminToDelete;
    }
    @Override
    public Set<Admin> getAll() { return new HashSet<>(repository.findAll()); }

    @Override
    public Admin findByContact(Contact contact) {
        return  repository.findByContact(contact);
    }

//    @Override
//    public Admin findByEmail(String email) {
//        return repository.findByContact_Email(email);
//    }

    public Set<Admin> findByFirstNameAndLastName(String firstName, String lastName) { return repository.findAllByName_FirstNameAndName_LastName(firstName, lastName); }
}
