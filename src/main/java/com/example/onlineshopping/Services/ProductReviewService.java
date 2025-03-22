package com.example.onlineshopping.Services;


import com.example.onlineshopping.Model.ProductReview;
import com.example.onlineshopping.Repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewService {
    private  final ProductReviewRepository productReviewRepository;

    @Autowired
    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    // Add a new product review
    public ProductReview addProductReview(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    // Update an existing product review

    public ProductReview updateProductReview(Long id, ProductReview updatedProductReview) {
        Optional<ProductReview> existingProductReview = productReviewRepository.findById(id);
        if (existingProductReview.isPresent()) {
            ProductReview productReview = existingProductReview.get();
            productReview.setRating(updatedProductReview.getRating());
            productReview.setComment(updatedProductReview.getComment());
            return productReviewRepository.save(productReview);
        } else {
            throw new RuntimeException("Product review not found with id: " + id);
        }
    }

    // Delete a product review by ID
    public void deleteProductReview(Long id) {
        productReviewRepository.deleteById(id);
    }

    // Get all product reviews
    public List<ProductReview> getAllProductReviews() {
        return productReviewRepository.findAll();
    }

    // Get a product review by product ID
    public List<ProductReview> getProductReviewByProductId(Long productId) {
        return productReviewRepository.findByProduct_ProductId(productId);
    }

    // Get a product review by ID
    public Optional<ProductReview> getProductReviewById(Long id) {
        return productReviewRepository.findById(id);
    }

    // Get a product review by customer ID
    public List<ProductReview> getProductReviewByCustomerId(Long customerId) {
        return productReviewRepository.findByCustomer_CustomerId(customerId);
    }


}
