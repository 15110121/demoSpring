package com.exercise.springdemo.api.mapper;

import com.exercise.springdemo.api.dto.CategoryDTO;
import com.exercise.springdemo.domain.Category;

public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
}
