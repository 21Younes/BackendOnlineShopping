package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);

}
