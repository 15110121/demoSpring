package com.exercise.springdemo.api.mapper;

import com.exercise.springdemo.api.dto.ProductDTO;
import com.exercise.springdemo.domain.Product;

public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
}
