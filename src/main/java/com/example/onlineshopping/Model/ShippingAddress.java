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
@Table(name = "ShippingAddresses")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ShippindAdressId; // Unique identifier for the address
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer; // The customer that this address belongs to



    // Getters and setters
}
