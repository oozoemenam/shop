package com.outland.shop.service.impl;

import com.outland.shop.model.Order;
import com.outland.shop.model.OrderItem;
import com.outland.shop.repository.OrderItemRepository;
import com.outland.shop.repository.OrderRepository;
import com.outland.shop.service.OrderItemService;
import com.outland.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(List<OrderItem> orderItems) {
        Order newOrder = new Order();
        newOrder.setCreateAt(LocalDate.now());
        for (OrderItem orderItem : orderItems) {
            OrderItem newOrderItem = new OrderItem();
            newOrderItem.setOrder(newOrder);
            newOrderItem.setProduct(orderItem.getProduct());
            newOrderItem.setQuantity(orderItem.getQuantity());
            orderItemRepository.save(newOrderItem);
        }
        return orderRepository.save(newOrder);
    }
}
