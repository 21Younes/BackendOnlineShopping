package com.example.onlineshopping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long paymentId; // Unique payment identifier
    private String paymentDate; // Payment date
    private String paymentMethod;
    private double amount; // Payment amount (same as order total)
    private boolean paymentStatus; // Payment status (true = paid, false = not paid)

    //relationship with other models
    private Long orderId; // The order that this payment is for
    private Long vendorId; // The vendor that this payment is for
    private Long customerId; // The customer that this payment is for
}
