package za.ac.cput.service;

import za.ac.cput.domain.Admin;

import java.util.Set;

public interface AdminService extends IService<Admin, String> {
    //public void delete(String adminID);

    Admin delete(String adminId);
    Set<Admin> getAll();
}
