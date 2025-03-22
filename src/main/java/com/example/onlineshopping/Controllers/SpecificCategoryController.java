package com.example.onlineshopping.Controllers;

import com.example.onlineshopping.Model.SpecificCategory;
import com.example.onlineshopping.Services.SpecificCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specificcategories")
public class SpecificCategoryController {
    private final SpecificCategoryService specificCategoryService;

    @Autowired
    public SpecificCategoryController(SpecificCategoryService specificCategoryService) {
        this.specificCategoryService = specificCategoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SpecificCategory>> getAllCategoriesByAgeAndSex() {
        return ResponseEntity.ok(specificCategoryService.getAllCategoriesByAgeAndSex());
    }

    @GetMapping("/{id}")
    public Optional<SpecificCategory> getCategoryById(@PathVariable Long id) {
        return specificCategoryService.getCategoryById(id);
    }

}
