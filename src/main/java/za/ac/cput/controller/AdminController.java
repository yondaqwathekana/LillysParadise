package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.request.LoginRequest;
import za.ac.cput.domain.Admin;
import za.ac.cput.response.LoginResponse;
import za.ac.cput.service.impl.AdminServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminServiceImpl adminService;
    @Autowired
    public AdminController(AdminServiceImpl adminService) { this.adminService = adminService; }
    @PostMapping("/create")
    public Admin createAdmin(@RequestBody Admin admin){ return adminService.create(admin); }
    @GetMapping("/read/{adminId}")
    public Admin readAdmin(@PathVariable String adminId){ return adminService.read(adminId); }
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin){ return adminService.update(admin); }
    @DeleteMapping("/delete/{adminId}")
    public Admin deleteAdmin(@PathVariable String adminId){ return adminService.delete(adminId);}
    @GetMapping("/getall")
    public Set<Admin> getAllAdmins(){ return adminService.getAll(); }
    @GetMapping("/search")
    public Set<Admin> getByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){ return  adminService.findByFirstNameAndLastName(firstName, lastName); }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        //   System.out.println("Received login request for email: " + loginRequest.getEmail());
        Admin admin = adminService.findByEmail(loginRequest.getEmail());
        //   System.out.println("Admin found: " + (admin != null));


        if (admin == null) {
            return new ResponseEntity<>("Email not found", HttpStatus.UNAUTHORIZED);
        }


        if (!admin.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.UNAUTHORIZED);
        }


        return new ResponseEntity<>(new LoginResponse("Login successful"), HttpStatus.OK);
    }
}
