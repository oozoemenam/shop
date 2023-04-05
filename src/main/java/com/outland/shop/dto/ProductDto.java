package com.outland.shop.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDto {
    private long id;

    private String name;

    private double price;

    private String imageUrl;
}
