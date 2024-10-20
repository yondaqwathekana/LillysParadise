package za.ac.cput.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Guest;
import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginUserDto;
import za.ac.cput.dto.RegisterUserDto;
import za.ac.cput.dto.VerifyUserDto;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.response.LoginResponse;
import za.ac.cput.response.ResponseMessage;
import za.ac.cput.service.impl.GuestServiceImpl;
import za.ac.cput.service.security.AuthService;
import za.ac.cput.service.security.JwtService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private final GuestServiceImpl guestService;
    private final JwtService jwtService;
    private final AuthService authService;

    @Autowired
    public GuestController(GuestServiceImpl guestService, JwtService jwtService, AuthService authService) {
        this.guestService = guestService;
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerGuest(@RequestBody RegisterUserDto registerUserDto) {
        try {
            // Guests will be persisted and automatically assigned the Guest role
            Guest registeredGuest = authService.guestSignUp(registerUserDto);
            return ResponseEntity.ok(registeredGuest);
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyGuest(@RequestBody VerifyUserDto verifyUserDto) {
        try {
            authService.verifyGuest(verifyUserDto);
            ResponseMessage responseMessage = new ResponseMessage("Guest account verified", "success");
            return ResponseEntity.ok(responseMessage);
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateGuest(@RequestBody LoginUserDto loginUserDto) {
        try {
            Guest guest = authService.guestSignIn(loginUserDto);
            String token = jwtService.generateToken(guest);
            String role = guest.getRoles().isEmpty() ? "Guest" : guest.getRoles().iterator().next().getName();
            LoginResponse loginResponse = new LoginResponse(token, jwtService.getExpirationTime(), guest.getUsername(), role);

            return ResponseEntity.ok(loginResponse);
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public ResponseEntity<Guest> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Guest currentUser = (Guest) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/find/{email}")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public ResponseEntity<?> findGuestByEmail(@PathVariable String email) {
        try {
            Optional<User> user = guestService.findByEmail(email);
            if (user.isPresent()) {
                return new ResponseEntity<>(user.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/logout")
    @PreAuthorize("hasRole('ROLE_GUEST')")
    public ResponseEntity<?> guestLogout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("No valid token found.");
        }
        String token = authHeader.substring(7);
        System.out.println("Logging out with Token: " + token);
        jwtService.blackListToken(token);
        return ResponseEntity.ok("Successfully logged out and token blacklisted.");
    }

    @GetMapping("/read/{guest_id}")
    public Guest readGuest(@PathVariable UUID guest_id) {
        return guestService.read(guest_id);
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

}