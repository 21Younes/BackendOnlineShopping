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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reviewId")
@Table(name = "ProductReviews")
public class ProductReview {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long reviewId;
    private int rating;
    private String Comment;

    //relationship between the review and the product
    @ManyToOne()

    @JoinColumn(name = "productId")
    private Product product;


    //relationship between the review and the customer


    @ManyToOne()

    @JoinColumn(name = "customerId")
    private Customer customer;
}
