package com.example.onlineshopping.Repository;


import com.example.onlineshopping.Model.SpecificCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificCategoryRepository  extends JpaRepository<SpecificCategory, Long> {
    List<SpecificCategory> findByName(String name);

}
