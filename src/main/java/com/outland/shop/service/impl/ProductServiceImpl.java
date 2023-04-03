package com.outland.shop.service.impl;

import com.outland.shop.exception.ResourceNotFoundException;
import com.outland.shop.model.Product;
import com.outland.shop.repository.ProductRepository;
import com.outland.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
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
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
