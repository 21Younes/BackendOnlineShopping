package com.example.onlineshopping.Model;


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
@Table(name = "specificcategories")
public class SpecificCategory {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long specificCategoryId;
    private String name;
    private String Description;

    //constructors
    public SpecificCategory(String name, String description) {
        this.name = name;
        Description = description;
    }

    //Relationship with product
    @OneToMany(mappedBy = "specificCategory", cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();



}
