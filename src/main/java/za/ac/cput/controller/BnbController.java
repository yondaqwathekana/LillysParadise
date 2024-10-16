package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Bnb;
import za.ac.cput.service.BnbService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bnb")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class BnbController {

    private final BnbService service;
    @Autowired
    public BnbController(BnbService service) { this.service = service; }

    @PostMapping("/create")
    public Bnb create(@RequestBody Bnb bnb){
        return service.create(bnb);
    }
    @GetMapping("/read/{bnbId}")
    public Bnb read(@PathVariable UUID bnbId){
        return service.read(bnbId);
    }
    @PostMapping("/update")
    public Bnb update(@RequestBody Bnb bnb){
        return service.update(bnb);
    }
    @GetMapping("/getall")
    public List<Bnb> getAll(){
        return service.getAll();
    }
}
