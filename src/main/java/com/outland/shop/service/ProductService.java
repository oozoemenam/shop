package com.outland.shop.service;

import com.outland.shop.model.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import org.springframework.validation.annotation.Validated;

@Validated
public interface ProductService {

    Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID") long id);

    Product createProduct(Product product);

    Iterable<Product> createAllProducts(List<Product> products);
}
