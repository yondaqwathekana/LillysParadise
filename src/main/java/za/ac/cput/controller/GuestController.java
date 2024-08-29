package za.ac.cput.controller;
import za.ac.cput.response.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Guest;
import za.ac.cput.service.impl.GuestServiceImpl;

import za.ac.cput.request.LoginRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private final GuestServiceImpl guestService;

    @Autowired
    public GuestController(GuestServiceImpl guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/create")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.create(guest);
    }

    @GetMapping("/read/{guest_id}")
    public Guest readGuest(@PathVariable UUID guest_id) {
        return guestService.read(String.valueOf(guest_id));
    }

    @PutMapping("/update")
    public Guest updateGuest(@RequestBody Guest guest) {
        return guestService.update(guest);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Server is running");
    }


    @GetMapping("/getall")
    public List<Guest> getAllGuests() {
        return guestService.getAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Find the guest by email
        Guest guest = guestService.findByEmail(loginRequest.getEmail());

        // Check if guest exists
        if (guest == null) {
            return new ResponseEntity<>("Email not found", HttpStatus.UNAUTHORIZED);
        }

        // Check if the password matches (ensure both are in plain text if not encrypting)
        if (!guest.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.UNAUTHORIZED);
        }

        // If successful, return a success message
        return new ResponseEntity<>(new LoginResponse("Login successful"), HttpStatus.OK);
    }
}