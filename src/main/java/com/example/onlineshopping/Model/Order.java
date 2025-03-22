package com.example.onlineshopping.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer; // The customer who placed the order

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> Items;

    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor vendor; // The vendor who will fulfill the order

    private double totalAmount;
    private String status; // "PENDING", "SHIPPED", "DELIVERED"
}