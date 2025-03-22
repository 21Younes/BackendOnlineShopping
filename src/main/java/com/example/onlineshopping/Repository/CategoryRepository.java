package com.example.onlineshopping.Repository;

import com.example.onlineshopping.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
    Category findByCategoryParent_CategoryParentId(Long categoryParentId);

}
