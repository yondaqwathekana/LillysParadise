package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Bnb;
import za.ac.cput.service.BnbService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bnb")
public class BnbController {

    @Autowired
    private BnbService service;

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
