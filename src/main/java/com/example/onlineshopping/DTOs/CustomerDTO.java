package com.example.onlineshopping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String email;

    private List<OrderDTO> orders; // List of orders made by the customer
    private List<ReviewDTO> reviews; // List of reviews written by the customer
    private List<ShippingAddressDTO> shippingAddresses; // Only storing shipping address IDs
    private List<PaymentDTO> payments; // Only storing payment IDs
}
