package com.exercise.springdemo.service.impl;

import com.exercise.springdemo.api.dto.CategoryDTO;
import com.exercise.springdemo.api.mapper.CategoryMapper;
import com.exercise.springdemo.api.mapper.ProductMapper;
import com.exercise.springdemo.domain.Category;
import com.exercise.springdemo.exception.RelatedResourceException;
import com.exercise.springdemo.exception.ResourceNotFoundException;
import com.exercise.springdemo.repository.CategoryRepository;
import com.exercise.springdemo.repository.ProductRepository;
import com.exercise.springdemo.service.CategoryService;
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
    public CategoryDTO getCategory(int categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent())
            return categoryMapper.categoryToCategoryDTO(optionalCategory.get());
        else
            throw new ResourceNotFoundException("Category " + categoryId + " not found");
    }

    @Override
    public void deleteCategory(int categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (!optionalCategory.isPresent()) {
            throw new ResourceNotFoundException("Category " + categoryId + " not found");
        }
        Category foundCategory = optionalCategory.get();
        if (!foundCategory.getProducts().isEmpty()) {
            throw new RelatedResourceException("Can not delete. " + foundCategory.getProducts().size() + " product is contained");
        } else {
            categoryRepository.deleteById(categoryId);
        }
    }
}
