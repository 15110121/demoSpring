package com.exercise.springdemo.repository;

import com.exercise.springdemo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
