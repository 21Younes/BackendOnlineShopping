package com.example.onlineshopping.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId; // Unique payment identifier
    private String paymentDate; // Payment date
    private String paymentMethod;
    private double amount; // Payment amount (same as order total)
    private boolean paymentStatus; // Payment status (true = paid, false = not paid)

    //relation to order
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Order order; // The order that this payment is for

    //relation to vendor
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorId")
    private Vendor vendor; // The vendor that this payment is for

    //relation for customer`
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;


}
