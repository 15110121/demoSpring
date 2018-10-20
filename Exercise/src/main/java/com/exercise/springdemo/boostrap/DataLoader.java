package com.exercise.springdemo.boostrap;

import com.exercise.springdemo.domain.Category;
import com.exercise.springdemo.domain.Product;
import com.exercise.springdemo.repository.CategoryRepository;
import com.exercise.springdemo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Category fruit = new Category();
        fruit.setName("Fruits");
        fruit.setDescription("This is good for your health 1");

        Category fresh = new Category();
        fresh.setName("Fresh");
        fresh.setDescription("This is good for your health 2");

        Category nuts = new Category();
        nuts.setName("Nuts");
        nuts.setDescription("This is good for your health 3");

        Category electronic = new Category();
        electronic.setName("Electronic");
        electronic.setDescription("This is electronic category");

        Category saveFruit = categoryRepository.save(fruit);
        Category saveFresh = categoryRepository.save(fresh);
        Category saveNuts = categoryRepository.save(nuts);
        Category saveElectronic = categoryRepository.save(electronic);

        Product apple = new Product();
        apple.setName("Apple");
        apple.setAmount(3);
        apple.setPrice(200);
        apple.setDescription("This is an apple");
        apple.setCategory(saveFruit);
        productRepository.save(apple);

        Product orange = new Product();
        orange.setName("Orange");
        orange.setAmount(3);
        orange.setPrice(200);
        orange.setDescription("This is an orange");
        orange.setCategory(saveFresh);
        productRepository.save(orange);

        Product lemon = new Product();
        lemon.setName("Lemon");
        lemon.setAmount(3);
        lemon.setPrice(200);
        lemon.setDescription("This is an lemon");
        lemon.setCategory(saveNuts);
        productRepository.save(lemon);
    }
}
