package com.outland.shop.controller;

import com.outland.shop.dto.OrderDto;
import com.outland.shop.dto.OrderItemDto;
import com.outland.shop.model.Order;
import com.outland.shop.model.OrderItem;
import com.outland.shop.service.OrderItemService;
import com.outland.shop.service.OrderService;
import com.outland.shop.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    private OrderDto convertToDto(Order order) {
        return modelMapper.map(order, OrderDto.class);
    }

    private Order convertToEntity(@Valid OrderDto orderDto) {
        return modelMapper.map(orderDto, Order.class);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = StreamSupport
                .stream(orderService.getAllOrders().spliterator(), false)
                .toList();
        List<OrderDto> orderDtos = orders
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody @Valid List<OrderItemDto> orderItemDtos) {
        //List<OrderItemDto> orderFormDtos = orderForm.getOrderItems();
        // validateProductsAvailable(orderFormDtos);

        List<OrderItem> orderItems = orderItemDtos
                .stream()
                .map(orderItemDto -> modelMapper.map(orderItemDto, OrderItem.class))
                .collect(Collectors.toList());
        Order order = orderService.createOrder(orderItems);
        return new ResponseEntity<>(convertToDto(order), HttpStatus.CREATED);
    }
}
