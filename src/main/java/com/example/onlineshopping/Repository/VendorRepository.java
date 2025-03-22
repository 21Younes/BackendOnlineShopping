package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Vendor findByUsername(String username);
}