package com.outland.shop.validation;

import com.outland.shop.dto.OrderItemDto;
import com.outland.shop.exception.ResourceNotFoundException;
import com.outland.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ProductValidation {
    private final ProductService productService;

    private void validateProductsAvailable(List<OrderItemDto> orderItemDtos) {
        List<OrderItemDto> productList = orderItemDtos
                .stream()
                .filter(orderItem -> Objects.isNull(productService.getProduct(
                        orderItem.getProduct().getId())))
                .toList();

        if (!CollectionUtils.isEmpty(productList)) {
            throw new ResourceNotFoundException("Products not found");
        }
    }
}
