package com.example.onlineshopping.Services;



import com.example.onlineshopping.Model.Vendor;
import com.example.onlineshopping.Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {


    private VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // Create a new vendor
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Get all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Get vendor by ID
    public Optional<Vendor> getVendorById(Long id) {
        return vendorRepository.findById(id);
    }

    // Get vendor by username
    public Optional<Vendor> getVendorByUsername(String username) {
        return Optional.ofNullable(vendorRepository.findByUsername(username));
    }

    // Update vendor details
    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        return vendorRepository.findById(id).map(vendor -> {
            vendor.setUsername(updatedVendor.getUsername());
            vendor.setEmail(updatedVendor.getEmail());
            vendor.setPassword(updatedVendor.getPassword()); // In a real system, encrypt passwords
            return vendorRepository.save(vendor);
        }).orElse(null);
    }

    // Delete a vendor
    public boolean deleteVendor(Long id) {
        if (vendorRepository.existsById(id)) {
            vendorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
