package com.exercise.springdemo.api.mapper.implmapper;

import com.exercise.springdemo.api.dto.CategoryDTO;
import com.exercise.springdemo.api.mapper.CategoryMapper;
import com.exercise.springdemo.api.mapper.ProductMapper;
import com.exercise.springdemo.domain.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    private final ProductMapper productMapper;

    public CategoryMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if(category==null) return null;
        else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setDescription(category.getDescription());
            categoryDTO.setProducts(category.getProducts().stream()
                    .map(productMapper::productToProductDTO)
                    .collect(Collectors.toSet()));
            return categoryDTO;
        }
    }
}
