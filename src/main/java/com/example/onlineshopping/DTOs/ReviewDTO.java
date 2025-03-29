package com.example.onlineshopping.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private int rating;
    private String comment;
    private Long productId;
    private Long customerId;
}
