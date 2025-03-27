package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "ShoppingCartItems")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shoppingCartId", nullable = false)
    private ShoppingCart shoppingCart; // Each item belongs to0 a shopping cart

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product; // The product in the cart

    private int quantity; // Quantity of the product in the cart
}
