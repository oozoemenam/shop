package com.outland.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.outland.shop.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByName(String categoryName);
}
