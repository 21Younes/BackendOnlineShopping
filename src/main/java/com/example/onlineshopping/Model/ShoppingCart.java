//package com.example.onlineshopping.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.HashMap;
//import java.util.Map;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "ShoppingCarts")
//public class ShoppingCart {
//    private Long ShoppingCartId; // Unique identifier for the shopping cart
//
//    @ManyToOne
//    @JoinColumn(name = "customerId")
//    private Customer customer; // The customer who owns the cart
//
//
//    private Map<Product, Integer> products; // Map of products and their quantities in the cart
//
//
//}
