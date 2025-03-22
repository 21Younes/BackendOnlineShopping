package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.Model.VendorProfile;
import com.example.onlineshopping.Services.VendorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-profiles")
public class VendorProfileController {

    @Autowired
    private VendorProfileService vendorProfileService;

    // Create a new vendor profile
    @PostMapping("/create")
    public ResponseEntity<VendorProfile> createVendorProfile(@RequestBody VendorProfile vendorProfile) {
        VendorProfile newVendorProfile = vendorProfileService.addVendorProfile(vendorProfile);
        return ResponseEntity.ok(newVendorProfile);
    }

    // Get all vendor profiles
    @GetMapping("/all")
    public ResponseEntity<List<VendorProfile>> getAllVendorProfiles() {
        return ResponseEntity.ok(vendorProfileService.getAllVendorProfiles());
    }

    // Get a vendor profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<VendorProfile> getVendorProfileById(@PathVariable Long id) {
        VendorProfile vendorProfile = vendorProfileService.getVendorProfileById(id);
        return vendorProfile != null ? ResponseEntity.ok(vendorProfile) : ResponseEntity.notFound().build();
    }

    // Update a vendor profile
    @PutMapping("/{id}")
    public ResponseEntity<VendorProfile> updateVendorProfile(@PathVariable Long id, @RequestBody VendorProfile updatedVendorProfile) {
        VendorProfile updatedProfile = vendorProfileService.updateVendorProfile(id, updatedVendorProfile);
        return updatedProfile != null ? ResponseEntity.ok(updatedProfile) : ResponseEntity.notFound().build();
    }

    // Delete a vendor profile
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendorProfile(@PathVariable Long id) {
        vendorProfileService.deleteVendorProfile(id);
        return ResponseEntity.ok("Vendor profile deleted successfully.");
    }
}
