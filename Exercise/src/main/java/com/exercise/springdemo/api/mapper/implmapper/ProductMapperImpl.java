package com.exercise.springdemo.api.mapper.implmapper;

import com.exercise.springdemo.api.dto.ProductDTO;
import com.exercise.springdemo.api.mapper.ProductMapper;
import com.exercise.springdemo.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product) {
        if (product == null)return null;
        else {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setAmount(product.getAmount());
            productDTO.setPrice(product.getPrice());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTO.setCategory(product.getCategory().getName());
            productDTO.setDescription(product.getDescription());
            return productDTO;
        }
    }
}
