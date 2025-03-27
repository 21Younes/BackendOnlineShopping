package com.example.onlineshopping.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ShippindAdressId")
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

    //relationship with customer
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer; // The customer that this address belongs to



    // Getters and setters
}
