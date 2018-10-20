package com.exercise.springdemo.repository;

import com.exercise.springdemo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
