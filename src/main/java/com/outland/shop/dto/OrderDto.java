package com.outland.shop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.outland.shop.enums.OrderStatus;
import com.outland.shop.model.OrderItem;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {
    private Long id;

    private List<OrderItemDto> orderItemDtos;

    private OrderStatus orderStatus;

    public Integer getNumberOfProducts() {
        return getOrderItemDtos().size();
    }

    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderItemDto> orderItemDtos = getOrderItemDtos();
        for (OrderItemDto orderItemDto : orderItemDtos) {
            sum += orderItemDto.getTotalPrice();
        }
        return sum;
    }

    private LocalDate createAt;
}
