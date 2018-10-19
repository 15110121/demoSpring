package com.exercise.springdemo.service;

import com.exercise.springdemo.api.dto.ProductDTO;
import com.exercise.springdemo.api.dto.create.ProductCreateDTO;
import com.exercise.springdemo.api.dto.update.ProductUpdateDTO;

import java.util.Set;

public interface ProductService {
    Set<ProductDTO> getAllProduct();

    ProductDTO createProduct(ProductCreateDTO productCreateDTO);

    ProductDTO updateProduct(ProductUpdateDTO productUpdateDTO);

    void deleteProduct(Long productID);
}
