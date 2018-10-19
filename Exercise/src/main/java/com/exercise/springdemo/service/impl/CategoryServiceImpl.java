package com.exercise.springdemo.service.impl;

import com.exercise.springdemo.api.dto.CategoryDTO;
import com.exercise.springdemo.api.mapper.CategoryMapper;
import com.exercise.springdemo.domain.Category;
import com.exercise.springdemo.exception.ResourseNotFoundException;
import com.exercise.springdemo.repository.CategoryRepository;
import com.exercise.springdemo.service.CategoryService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Set<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toSet());

    }

    @Override
    public CategoryDTO getCategory(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent())
            return categoryMapper.categoryToCategoryDTO(optionalCategory.get());
        else
            throw new ResourseNotFoundException("Category not found");
    }
}
