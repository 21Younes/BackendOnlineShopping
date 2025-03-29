package com.example.onlineshopping.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingAddressDTO {

    private Long ShippingAddressId; // Unique identifier for the address
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phoneNumber;
    //relationship with customer
    private Long customerId; // The customer that this address belongs to
}
