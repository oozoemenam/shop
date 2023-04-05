package com.outland.shop.service;

import com.outland.shop.model.OrderItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderItemService {

    OrderItem createOrderItem(@NotNull(message = "Items for order cannot be null") @Valid OrderItem orderItem);
}
