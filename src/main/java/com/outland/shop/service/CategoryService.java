package com.outland.shop.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.outland.shop.model.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Validated
public interface CategoryService {
    
    Iterable<Category> getAllCategories();

    Category getCategory(@Min(value = 1L, message = "Invalid category ID") long id);

    public Category getCategoryByName(@NotBlank String categoryName);

    Category createCategory(Category category);

    Iterable<Category> createAllCategories(List<Category> categories);
}
