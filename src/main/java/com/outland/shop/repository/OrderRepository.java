package com.outland.shop.repository;

import com.outland.shop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    // Iterable<Order> findAllByUserIdOrOrderByCreateAtDesc(Long userId);
}
