package com.outland.shop.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.outland.shop.dto.CategoryDto;
import com.outland.shop.model.Category;
import com.outland.shop.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    
    private final ModelMapper modelMapper;

    private CategoryDto convertToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }

    private Category convertToEntity(@Valid CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<Category> categories = StreamSupport
                .stream(categoryService.getAllCategories().spliterator(), false)
                .collect(Collectors.toList());
        List<CategoryDto> categoryDtos = categories
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }
}
