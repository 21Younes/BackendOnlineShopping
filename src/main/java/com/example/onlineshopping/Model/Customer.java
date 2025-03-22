package com.example.onlineshopping.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId; // Unique identifier for the customer
    private String username;
    private String sex;
    private int age;
    private String email;
    private String password; // In a real system, this would be encrypted

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>(); // List of orders made by the customer

    @OneToMany(mappedBy = "customer")
    private List<ProductReview> reviews = new ArrayList<>(); // List of reviews written by the customer

    @OneToMany(mappedBy = "customer")
    private List<ShippingAddress> shippingAddresses = new ArrayList<>(); // List of payments made by the customer


    @OneToMany(mappedBy = "customer")
    private List<Payment> payments = new ArrayList<>();
    //Constructor


    public Customer(Long customerId, String email, List<Order> orders, List<ProductReview> reviews, String password, String username) {
        this.customerId = customerId;
        this.email = email;
        this.orders = orders;
        this.reviews = reviews;
        this.password = password;
        this.username = username;
    }
}
