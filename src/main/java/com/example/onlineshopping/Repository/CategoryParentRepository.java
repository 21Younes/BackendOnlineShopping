package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.CategoryParent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryParentRepository extends JpaRepository<CategoryParent, Long> {
    CategoryParent findByCategoryParentName(String categoryParentName);

}
