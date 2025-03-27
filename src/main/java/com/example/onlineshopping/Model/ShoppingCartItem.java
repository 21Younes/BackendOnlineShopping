package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ShoppingCartItems")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "shoppingCartId", nullable = false)
    private ShoppingCart shoppingCart; // Each item belongs to0 a shopping cart

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "productId", nullable = false)
    private Product product; // The product in the cart

    private int quantity; // Quantity of the product in the cart
}
