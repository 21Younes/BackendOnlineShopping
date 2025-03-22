package com.example.onlineshopping.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CategoriesParent")
public class CategoryParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryParentId; // Unique category identifier
    private String categoryParentName; // Category name
    private String categoryParentDescription; // Category description
    private String categoryParentImage; // Category image

    //relation with the category
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryParent")
    private List<Category> categories = new ArrayList<>(); // The parent category of this category

    //Constructos

    public CategoryParent(String categoryName, String categoryDescription, String categoryImage) {
        this.categoryParentName = categoryName;
        this.categoryParentDescription = categoryDescription;
        this.categoryParentImage = categoryImage;
    }


}
