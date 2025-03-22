package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.Model.ShippingAddress;
import com.example.onlineshopping.Services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipping-addresses")
public class ShippingAddressController {


    private ShippingAddressService shippingAddressService;

    @Autowired
    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    // Create a new shipping address
    @PostMapping("/create")
    public ResponseEntity<ShippingAddress> createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        return ResponseEntity.ok(shippingAddressService.addShippingAddress(shippingAddress));
    }

    // Get all shipping addresses
    @GetMapping("/all")
    public ResponseEntity<List<ShippingAddress>> getAllShippingAddresses() {
        return ResponseEntity.ok(shippingAddressService.getAllShippingAddresses());
    }

    // Get a shipping address by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShippingAddress> getShippingAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(shippingAddressService.getShippingAddressById(id));
    }

    // Get shipping addresses by Customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ShippingAddress>> getShippingAddressesByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(shippingAddressService.getShippingAddressesByCustomerId(customerId));
    }

    // Delete a shipping address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShippingAddress(@PathVariable Long id) {
        shippingAddressService.deleteShippingAddress(id);
        return ResponseEntity.ok("Shipping address deleted successfully.");
    }
}
