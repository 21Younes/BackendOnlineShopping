package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByCustomer_customerId(Long customerId);
}
