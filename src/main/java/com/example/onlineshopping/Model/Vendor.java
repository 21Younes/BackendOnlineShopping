package com.example.onlineshopping.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId; // Unique identifier for the vendor
    private String username;
    private String email;
    private String password; // In a real system, this would be encrypted


    @OneToMany(mappedBy = "vendor")
    private List<Product> products = new ArrayList<>();// List of products the vendor sells

    @OneToMany(mappedBy = "vendor")
    private List<Order> orders = new ArrayList<>();// List of orders made by customers that are handled by this vendor

    @OneToMany(mappedBy = "vendor")
    private List<Payment> payments = new ArrayList<>();// List of payments made to this vendor




}
