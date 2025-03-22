package com.example.onlineshopping.Model;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    private String description;
    private String image;

    //relation to product

    @OneToMany(mappedBy = "category" )
    private List<Product> products = new ArrayList<>();

    //relation to categoryparnt

    @ManyToOne()
    @JoinColumn(name = "categoryParentId")
    private CategoryParent categoryParent;



    public Category(String description, String name, List<Product> products) {
        this.description = description;
        this.name = name;
        this.products = products;
    }

}