package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.service.ContactService;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository repository;
    @Autowired
    ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }
    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }
    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }
}
