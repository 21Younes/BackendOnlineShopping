package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    List<ProductReview> findByProduct_ProductId(Long productId);
    List<ProductReview> findByCustomer_CustomerId(Long customerId);

}
