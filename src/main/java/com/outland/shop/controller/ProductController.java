package com.outland.shop.controller;

import com.outland.shop.dto.ProductDto;
import com.outland.shop.model.Product;
import com.outland.shop.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    private ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private Product convertToEntity(@Valid ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = StreamSupport
                .stream(productService.getAllProducts().spliterator(), false)
                .toList();
        List<ProductDto> productDtos = products
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
}
