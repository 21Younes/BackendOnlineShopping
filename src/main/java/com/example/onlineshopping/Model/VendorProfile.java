package com.example.onlineshopping.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VendorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorProfileId;

    private String storeName;

    private String description;

    private double rating;

    private String storeImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorId")
    private Vendor vendor;



    //constructors


    public VendorProfile(String storeName, String description, double rating) {
        this.storeName = storeName;
        this.description = description;
        this.rating = rating;
    }

    //getters and setters


}