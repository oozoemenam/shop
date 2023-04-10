package com.outland.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.outland.shop.exception.ResourceNotFoundException;
import com.outland.shop.model.Category;
import com.outland.shop.repository.CategoryRepository;
import com.outland.shop.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> createAllCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
}
