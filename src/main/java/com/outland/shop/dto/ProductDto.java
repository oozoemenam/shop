package com.outland.shop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private Double price;

    private String description;

    private CategoryDto category;
    
    private String imageUrl;
}
