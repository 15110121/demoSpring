package com.exercise.springdemo.api.mapper;

import com.exercise.springdemo.api.dto.CategoryDTO;
import com.exercise.springdemo.domain.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
}
