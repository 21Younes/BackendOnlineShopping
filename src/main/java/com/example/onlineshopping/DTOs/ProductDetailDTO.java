package com.example.onlineshopping.DTOs;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProductDetailDTO {
    private Long productId;
    private String name;
    private String description;
    private String image;
    private double price;
    private int stockQuantity;
    private Long vendorId;
    private Long categoryId;
    private Long specificCategoryId;
    private List<ReviewDTO> reviews;
}
