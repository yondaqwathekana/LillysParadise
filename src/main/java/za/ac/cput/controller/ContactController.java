package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/create")
    public Contact create (@RequestBody Contact contact){
        return service.create(contact);
    }
    @GetMapping("/read/{email}")
    public Contact read(@PathVariable String email){
        return service.read(email);
    }
    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){
        return service.update(contact);
    }
    @GetMapping("/getall")
    public List<Contact> getAll(){
        return service.getAll();
    }
}
