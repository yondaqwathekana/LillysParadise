package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.impl.RoomServiceServiceImp;
import za.ac.cput.domain.RoomService;

import java.util.Set;

@RestController
@RequestMapping("/roomService")


public class RoomSController {

    private final RoomServiceServiceImp RoomServiceService;
    @Autowired
    public RoomSController(RoomServiceServiceImp RoomServiceService) {this.RoomServiceService = RoomServiceService;}
    @PostMapping("/create")
    public RoomService creatRoom(@RequestBody RoomService room){ return RoomServiceService.create(room); }
    @GetMapping("/read/{serviceName}")
    public RoomService readRoom(@PathVariable String serviceName){ return RoomServiceService.read(serviceName); }
    @PutMapping("/update")
    public RoomService updateRoom(@RequestBody RoomService room){ return RoomServiceService.update(room); }
    @GetMapping("/getall")
    public Set<RoomService> getAllPayments(){ return RoomServiceService.getAll(); }
}
