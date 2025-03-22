package com.example.onlineshopping.Services;

import com.example.onlineshopping.Model.VendorProfile;
import com.example.onlineshopping.Repository.VendorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorProfileService {
    private final VendorProfileRepository vendorProfileRepository;

    @Autowired
    public VendorProfileService(VendorProfileRepository vendorProfileRepository) {
        this.vendorProfileRepository = vendorProfileRepository;
    }

    // Add a new vendor profile
    public VendorProfile addVendorProfile(VendorProfile vendorProfile) {
        return vendorProfileRepository.save(vendorProfile);
    }

    // Update an existing vendor profile
    public VendorProfile updateVendorProfile(Long id, VendorProfile updatedVendorProfile) {
        return vendorProfileRepository.findById(id).map(vendorProfile -> {
            vendorProfile.setDescription(updatedVendorProfile.getDescription());
            vendorProfile.setStoreName(updatedVendorProfile.getStoreName());
            vendorProfile.setRating(updatedVendorProfile.getRating());
            return vendorProfileRepository.save(vendorProfile);
        }).orElse(null);
    }

    // Delete a vendor profile by ID
    public void deleteVendorProfile(Long id) {
        vendorProfileRepository.deleteById(id);
    }

    // Get all vendor profiles
    public List<VendorProfile> getAllVendorProfiles() {
        return vendorProfileRepository.findAll();
    }

    // Get a vendor profile by ID
    public VendorProfile getVendorProfileById(Long id) {
        return vendorProfileRepository.findById(id).orElse(null);
    }


}
