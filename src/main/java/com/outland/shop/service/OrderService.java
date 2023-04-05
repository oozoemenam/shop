package com.outland.shop.service;

import com.outland.shop.model.Order;
import com.outland.shop.model.OrderItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface OrderService {

    Iterable<Order> getAllOrders();

    Order createOrder(@NotNull(message = "Order cannot be null") @Valid List<OrderItem> orderItems);
}
