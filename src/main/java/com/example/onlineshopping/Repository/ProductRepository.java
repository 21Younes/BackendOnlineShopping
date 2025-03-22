package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByVendor_VendorId(Long vendorId);
    List<Product> findByCategory_CategoryId(Long categoryId);
    List<Product> findBySpecificCategory_SpecificCategoryId(Long specificCategoryId);

}