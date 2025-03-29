package com.example.onlineshopping.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "categoryId")
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