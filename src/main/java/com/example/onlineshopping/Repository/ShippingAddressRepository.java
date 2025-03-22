package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
    List<ShippingAddress> findByCustomer_CustomerId(Long customerId);
}
