package com.example.onlineshopping.Controllers;


import com.example.onlineshopping.DTOs.ProductDetailDTO;
import com.example.onlineshopping.DTOs.ReviewDTO;
import com.example.onlineshopping.Model.Product;
import com.example.onlineshopping.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    // Create a new product
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    // Get all products
    @GetMapping("/all")
    public ResponseEntity<List<ProductDetailDTO>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        List<ProductDetailDTO> productDetailDTOS = products.stream().map(product -> {
            ProductDetailDTO productDetailDTO = new ProductDetailDTO();
            productDetailDTO.setProductId(product.getProductId());
            productDetailDTO.setName(product.getName());
            productDetailDTO.setImage(product.getImage());
            productDetailDTO.setDescription(product.getDescription());
            productDetailDTO.setPrice(product.getPrice());
            productDetailDTO.setStockQuantity(product.getStockQuantity());
            productDetailDTO.setVendorId(product.getVendor().getVendorId());
            productDetailDTO.setCategoryId(product.getCategory().getCategoryId());
            productDetailDTO.setSpecificCategoryId(product.getSpecificCategory().getSpecificCategoryId());


            List<ReviewDTO> reviewDTOs = product.getProductReviews().stream()
                    .map(productReview -> {
                        ReviewDTO reviewDTO = new ReviewDTO();
                        reviewDTO.setRating(productReview.getRating());
                        reviewDTO.setComment(productReview.getComment());
                        reviewDTO.setCustomerId(productReview.getCustomer().getCustomerId());
                        reviewDTO.setProductId(productReview.getProduct().getProductId());
                        return reviewDTO;
                    }).collect(Collectors.toList());

            productDetailDTO.setReviews(reviewDTOs);

            return productDetailDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(productDetailDTOS);
    }



    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getProductById(@PathVariable Long id) {
         Product product = productService.getProductById(id).orElseThrow( () -> new RuntimeException("Product not found"));
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setProductId(product.getProductId());
        productDetailDTO.setName(product.getName());
        productDetailDTO.setImage(product.getImage());
        productDetailDTO.setDescription(product.getDescription());
        productDetailDTO.setPrice(product.getPrice());
        productDetailDTO.setStockQuantity(product.getStockQuantity());
        productDetailDTO.setVendorId(product.getVendor().getVendorId());
        productDetailDTO.setCategoryId(product.getCategory().getCategoryId());
        productDetailDTO.setSpecificCategoryId(product.getSpecificCategory().getSpecificCategoryId());

        List<ReviewDTO> reviewDTOs = product.getProductReviews().stream()
                .map(productReview -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setRating(productReview.getRating());
                    reviewDTO.setComment(productReview.getComment());
                    reviewDTO.setCustomerId(productReview.getCustomer().getCustomerId());
                    reviewDTO.setProductId(productReview.getProduct().getProductId());
                    return reviewDTO;
                }).collect(Collectors.toList());

        productDetailDTO.setReviews(reviewDTOs);
        return ResponseEntity.ok(productDetailDTO);
    }


    // Get products by Vendor ID
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<Product>> getProductsByVendorId(@PathVariable Long vendorId) {
        return ResponseEntity.ok(productService.getProductsByVendorId(vendorId));
    }

    // Get products by Category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId));
    }

    // Get products by Specific Category ID
    @GetMapping("/specificcategory/{specificCategoryId}")
    public ResponseEntity<List<ProductDetailDTO>> getProductsBySpecificCategoryId(@PathVariable Long specificCategoryId) {
        List<Product> products = productService.getProductsBySpecificCategoryId(specificCategoryId);

        List<ProductDetailDTO> productDetailDTOS = products.stream().map(product -> {
            ProductDetailDTO productDetailDTO = new ProductDetailDTO();
            productDetailDTO.setProductId(product.getProductId());
            productDetailDTO.setName(product.getName());
            productDetailDTO.setImage(product.getImage());
            productDetailDTO.setDescription(product.getDescription());
            productDetailDTO.setPrice(product.getPrice());
            productDetailDTO.setStockQuantity(product.getStockQuantity());
            productDetailDTO.setVendorId(product.getVendor().getVendorId());
            productDetailDTO.setCategoryId(product.getCategory().getCategoryId());
            productDetailDTO.setSpecificCategoryId(product.getSpecificCategory().getSpecificCategoryId());


            List<ReviewDTO> reviewDTOs = product.getProductReviews().stream()
                    .map(productReview -> {
                        ReviewDTO reviewDTO = new ReviewDTO();
                        reviewDTO.setRating(productReview.getRating());
                        reviewDTO.setComment(productReview.getComment());
                        reviewDTO.setCustomerId(productReview.getCustomer().getCustomerId());
                        reviewDTO.setProductId(productReview.getProduct().getProductId());
                        return reviewDTO;
                    }).collect(Collectors.toList());

            productDetailDTO.setReviews(reviewDTOs);

            return productDetailDTO;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(productDetailDTOS);


    }

    // Update product details
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id) ?
                ResponseEntity.ok("Product deleted successfully.") :
                ResponseEntity.notFound().build();
    }
}
