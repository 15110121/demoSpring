package com.exercise.springdemo.api.mapper;

import com.exercise.springdemo.api.dto.ProductDTO;
import com.exercise.springdemo.domain.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
}
