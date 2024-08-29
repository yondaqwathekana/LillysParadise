package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
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
}
