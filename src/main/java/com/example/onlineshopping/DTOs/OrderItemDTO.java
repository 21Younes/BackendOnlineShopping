package com.example.onlineshopping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double priceAtPurchase;
    //relationship between the orderItem and other models
    private Long orderId; // The order that this item belongs to
    private Long productId; // The product that this item represents
}
