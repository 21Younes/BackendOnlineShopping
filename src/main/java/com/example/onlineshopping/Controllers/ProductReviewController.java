package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.Model.ProductReview;
import com.example.onlineshopping.Services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewController {


    private final ProductReviewService productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    // Create a new review
    @PostMapping("/create")
    public ResponseEntity<ProductReview> createReview(@RequestBody ProductReview review) {
        return ResponseEntity.ok(productReviewService.addProductReview(review));
    }

    // Get all reviews
    @GetMapping("/all")
    public ResponseEntity<List<ProductReview>> getAllReviews() {
        return ResponseEntity.ok(productReviewService.getAllProductReviews());
    }

    // Get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductReview> getReviewById(@PathVariable Long id) {
        return productReviewService.getProductReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get reviews by Product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductReview>> getReviewsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productReviewService.getProductReviewByProductId(productId));
    }

    // Get reviews by Customer ID
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ProductReview>> getReviewsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(productReviewService.getProductReviewByCustomerId(customerId));
    }

    // Delete a review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        productReviewService.deleteProductReview(id);
        return ResponseEntity.ok("Review deleted successfully.");
    }
}
