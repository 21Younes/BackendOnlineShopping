package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    //relationship between the order and the customer
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customerId")
    private Customer customer; // The customer who placed the order



    //relationship between the order and the order item
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> Items;


    //relationship between the order and the vendor
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor vendor; // The vendor who will fulfill the order

    private double totalAmount;
    private String status; // "PENDING", "SHIPPED", "DELIVERED"
}