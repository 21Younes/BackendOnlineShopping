package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOrder_OrderId(Long orderId);
    Payment findByCustomer_CustomerId(Long customerId);
    Payment findByVendor_VendorId(Long customerId);
}
