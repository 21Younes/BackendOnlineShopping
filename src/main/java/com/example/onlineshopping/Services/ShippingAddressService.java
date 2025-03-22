package com.example.onlineshopping.Services;

import com.example.onlineshopping.Model.ShippingAddress;
import com.example.onlineshopping.Repository.ShippingAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingAddressService {
    private final ShippingAddressRepository shippingAddressRepository;

    @Autowired
    public ShippingAddressService(ShippingAddressRepository shippingAddressRepository) {
        this.shippingAddressRepository = shippingAddressRepository;
    }

    // Add a new shipping address
    public ShippingAddress addShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressRepository.save(shippingAddress);
    }

    // Update an existing shipping address
    public ShippingAddress updateShippingAddress(Long id, ShippingAddress updatedShippingAddress) {
        return shippingAddressRepository.findById(id)
                .map(shippingAddress -> {
                    shippingAddress.setCity(updatedShippingAddress.getCity());
                    shippingAddress.setStreet(updatedShippingAddress.getStreet());
                    shippingAddress.setCountry(updatedShippingAddress.getCountry());
                    shippingAddress.setPostalCode(updatedShippingAddress.getPostalCode());
                    shippingAddress.setState(updatedShippingAddress.getState());
                    shippingAddress.setPhoneNumber(updatedShippingAddress.getPhoneNumber());
                    return shippingAddressRepository.save(shippingAddress);
                })
                .orElseThrow(() -> new RuntimeException("Shipping address not found with id: " + id));
    }

    // Delete a shipping address by ID
    public void deleteShippingAddress(Long id) {
        shippingAddressRepository.deleteById(id);
    }

    // Get all shipping addresses
    public List<ShippingAddress> getAllShippingAddresses() {
        return shippingAddressRepository.findAll();
    }

    // Get a shipping address by ID
    public ShippingAddress getShippingAddressById(Long id) {
        return shippingAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping address not found with id: " + id));
    }

    // Get shipping addresses by customer ID
    public List<ShippingAddress> getShippingAddressesByCustomerId(Long customerId) {
        return shippingAddressRepository.findByCustomer_CustomerId(customerId);
    }
}
