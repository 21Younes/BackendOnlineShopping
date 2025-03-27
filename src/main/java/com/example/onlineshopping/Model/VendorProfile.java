package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vendorProfileId")
@NoArgsConstructor
public class VendorProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorProfileId;

    private String storeName;

    private String description;

    private double rating;

    private String storeImage;

    @OneToOne()
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