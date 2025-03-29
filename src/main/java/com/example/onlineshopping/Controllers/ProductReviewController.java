package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.DTOs.ReviewDTO;
import com.example.onlineshopping.Model.Customer;
import com.example.onlineshopping.Model.Product;
import com.example.onlineshopping.Model.ProductReview;
import com.example.onlineshopping.Services.CustomerService;
import com.example.onlineshopping.Services.ProductReviewService;
import com.example.onlineshopping.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewController {



    private final ProductReviewService productReviewService;
    private final ProductService productService;
    private final CustomerService customerService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService, ProductService productService, CustomerService customerService) {
        this.productReviewService = productReviewService;
        this.productService = productService;
        this.customerService = customerService;
    }

    // Create a new review
    @PostMapping("/create")
    public ResponseEntity<ProductReview> createReview(@RequestBody ReviewDTO reviewDto) {
        //retrieve the product
        Product product = productService.getProductById(reviewDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + reviewDto.getProductId()));

        //retrieve the customer
       Customer customer = customerService.getCustomerById(reviewDto.getCustomerId()).orElseThrow(() -> new RuntimeException("customer not found"));;

        //adding the product review
        ProductReview review = new ProductReview();
        review.setRating(reviewDto.getRating());
        review.setComment(reviewDto.getComment());
        review.setProduct(product);
        review.setCustomer(customer);


        return ResponseEntity.ok(productReviewService.addProductReview(review));
    }

    // Get all reviews
    @GetMapping("/all")
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {

        List<ProductReview> reviews = productReviewService.getAllProductReviews();
        List<ReviewDTO> reviewDTOS = reviews.stream().map(review -> {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setRating(review.getRating());
            reviewDTO.setComment(review.getComment());
            reviewDTO.setProductId(review.getProduct().getProductId());
            reviewDTO.setCustomerId(review.getCustomer().getCustomerId());
            return reviewDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(reviewDTOS);
    }

    // Get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        return productReviewService.getProductReviewById(id)
                .map(review -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setRating(review.getRating());
                    reviewDTO.setComment(review.getComment());
                    reviewDTO.setProductId(review.getProduct().getProductId());
                    reviewDTO.setCustomerId(review.getCustomer().getCustomerId());
                    return ResponseEntity.ok(reviewDTO);
                })
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
