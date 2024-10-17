package za.ac.cput.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.domain.User;
import za.ac.cput.dto.LoginUserDto;
import za.ac.cput.dto.VerifyUserDto;
import za.ac.cput.response.LoginResponse;
import za.ac.cput.response.ResponseMessage;
import za.ac.cput.service.impl.AdminServiceImpl;
import za.ac.cput.service.security.AuthService;
import za.ac.cput.service.security.JwtService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;
    private final JwtService jwtService;
    private final AuthService authService;
    @Autowired
    public AdminController(AdminServiceImpl adminService, JwtService jwtService, AuthService authService) {
        this.adminService = adminService;
        this.jwtService = jwtService;
        this.authService = authService;
    }

    // No signup endpoint for Admin since admins are manually added via database

    @PostMapping("/verify")
    public ResponseEntity<?> verifyAdmin(@RequestBody VerifyUserDto verifyUserDto) {
        try {
            authService.verifyAdmin(verifyUserDto);
            ResponseMessage responseMessage = new ResponseMessage("Admin account verified", "success");
            return ResponseEntity.ok(responseMessage);
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateAdmin(@RequestBody LoginUserDto loginUserDto) {
        try {
            Admin admin = authService.adminSignIn(loginUserDto);
            String token = jwtService.generateToken(admin);
            String role = admin.getRoles().isEmpty() ? "Admin" : admin.getRoles().iterator().next().getName();
            LoginResponse loginResponse = new LoginResponse(token, jwtService.getExpirationTime(), admin.getUsername(), role);
            return ResponseEntity.ok(loginResponse);
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Admin currentUser = (Admin) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @PostMapping("/logout")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> adminLogout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("No valid token found.");
        }
        String token = authHeader.substring(7);
        System.out.println("Logging out with Token: " + token);
        jwtService.blackListToken(token);
        return ResponseEntity.ok("Successfully logged out and token blacklisted.");
    }

    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.update(admin);
    }
    @DeleteMapping("/delete/{adminId}")
    public Admin deleteAdmin(@PathVariable UUID adminId){ return adminService.delete(adminId);}
    @GetMapping("/getall")
    public Set<Admin> getAllAdmins(){ return adminService.getAll(); }
    @GetMapping("/search")
    public Set<Admin> getByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){ return  adminService.findByFirstNameAndLastName(firstName, lastName); }

}
