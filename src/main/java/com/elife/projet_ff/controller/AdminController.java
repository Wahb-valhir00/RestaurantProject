package com.elife.projet_ff.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elife.projet_ff.model.Admin;
import com.elife.projet_ff.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) {
        Admin authenticatedAdmin = adminService.authenticateAdmin(admin.getEmail(), admin.getPassword());
        if (authenticatedAdmin != null) {
            return ResponseEntity.ok(authenticatedAdmin);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Optional<Admin> existingAdmin = Optional.ofNullable(adminService.authenticateAdmin(admin.getEmail(), admin.getPassword()));
        if (existingAdmin.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // Admin already exists
        }
        Admin createAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createAdmin, HttpStatus.CREATED);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createAdmin, HttpStatus.CREATED);
    }
   
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> admins = adminService.getAllAdmin();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
   
    @GetMapping("/find/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable String id) {
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable String id) {
        admin.setId(id);
        Admin updatedAdmin = adminService.updateAdmin(admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }
   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdminById(@PathVariable String id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
