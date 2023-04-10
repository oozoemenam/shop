package com.outland.shop.service.impl;

import com.outland.shop.exception.ResourceNotFoundException;
import com.outland.shop.model.Product;
import com.outland.shop.repository.ProductRepository;
import com.outland.shop.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> createAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
}
