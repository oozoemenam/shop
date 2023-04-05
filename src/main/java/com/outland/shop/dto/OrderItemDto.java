package com.outland.shop.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private ProductDto product;

    private int quantity;

    public double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
}
