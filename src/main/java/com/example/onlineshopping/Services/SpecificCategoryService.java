package com.example.onlineshopping.Services;

import com.example.onlineshopping.Model.SpecificCategory;
import com.example.onlineshopping.Repository.SpecificCategoryRepository;
import com.example.onlineshopping.Repository.SpecificCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecificCategoryService {
    private final SpecificCategoryRepository specificCategoryRepository;

    @Autowired
    public SpecificCategoryService(SpecificCategoryRepository specificCategoryRepository) {
        this.specificCategoryRepository = specificCategoryRepository;
    }

    // Get all categories by age and sex
    public List<SpecificCategory> getAllCategoriesByAgeAndSex() {
        return specificCategoryRepository.findAll();
    }

    // get a category by age and sex by id
    public Optional<SpecificCategory> getCategoryById(Long id) {
        return specificCategoryRepository.findById(id);
    }
}
