package com.example.onlineshopping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderDTO {
    private Long orderId;
    private double totalAmount;
    private String status; // "PENDING", "SHIPPED", "DELIVERED"
    //relationship between the order and other models

    private Long customerId; // The customer who placed the order
    private Long vendorId; // The vendor who will fulfill the order
    private List<OrderItemDTO> Items;

}
