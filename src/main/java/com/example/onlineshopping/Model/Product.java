package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private String image;
    private double price;
    private int stockQuantity;

    //relation with the vendor

    @ManyToOne
    @JoinColumn(name = "vendorId" )
    private Vendor vendor; // The vendor who sells this product

    // relation with the category

    @ManyToOne
    @JoinColumn(name = "categoryid" )
    private Category category;

    // relation with categorybysexandage

    @ManyToOne
    @JoinColumn(name = "specificCategoryId") // Ensure this matches the column name in DB
    private SpecificCategory specificCategory;


    //relation with the product review

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductReview> productReviews = new ArrayList<>();// The reviews of this product

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();// The reviews of this product



    //constructors

    public Product(String name, String description, double price, int stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }




}