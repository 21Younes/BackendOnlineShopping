package com.example.onlineshopping.Controllers;



import com.example.onlineshopping.Model.Vendor;
import com.example.onlineshopping.Services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // Create a new vendor
    @PostMapping("/create")
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        System.out.println("received vendor : " + vendor);
        return ResponseEntity.ok(vendorService.createVendor(vendor));
    }

    // Get all vendors
    @GetMapping("/all")
    public ResponseEntity<List<Vendor>> getAllVendors() {

        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    // Get vendor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get vendor by username
    @GetMapping("/username/{username}")
    public ResponseEntity<Vendor> getVendorByUsername(@PathVariable String username) {
        return vendorService.getVendorByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update vendor details
    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        Vendor updatedVendor = vendorService.updateVendor(id, vendor);
        return updatedVendor != null ? ResponseEntity.ok(updatedVendor) : ResponseEntity.notFound().build();
    }

    // Delete vendor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        return vendorService.deleteVendor(id) ?
                ResponseEntity.ok("Vendor deleted successfully.") :
                ResponseEntity.notFound().build();
    }
}
