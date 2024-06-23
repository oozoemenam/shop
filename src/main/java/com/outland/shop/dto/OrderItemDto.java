package com.outland.shop.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private ProductDto product;

    private Integer quantity;

    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
}
