package com.exercise.springdemo.service;

import com.exercise.springdemo.api.dto.CategoryDTO;

import java.util.Set;

public interface CategoryService {

    Set<CategoryDTO> getAllCategory();

    CategoryDTO getCategory(int categoryId);

    void deleteCategory(int categoryId);
}
