package com.exercise.springdemo.service.impl;

import com.exercise.springdemo.api.dto.ProductDTO;
import com.exercise.springdemo.api.dto.create.ProductCreateDTO;
import com.exercise.springdemo.api.dto.update.ProductUpdateDTO;
import com.exercise.springdemo.api.mapper.ProductMapper;
import com.exercise.springdemo.domain.Category;
import com.exercise.springdemo.domain.Product;
import com.exercise.springdemo.exception.ResourceNotFoundException;
import com.exercise.springdemo.repository.CategoryRepository;
import com.exercise.springdemo.repository.ProductRepository;
import com.exercise.springdemo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream().map(productMapper::productToProductDTO).collect(Collectors.toSet());
    }

    @Override
    public ProductDTO createProduct(ProductCreateDTO productCreateDTO) {
        Optional<Category> optionalCategory = categoryRepository.findById(productCreateDTO.getCategoryId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();

            Product product = new Product();
            product.setName(productCreateDTO.getName());
            product.setAmount(productCreateDTO.getAmount());
            product.setPrice(productCreateDTO.getPrice());
            product.setDescription(productCreateDTO.getDescription());
            product.setCategory(category);
            productRepository.save(product);

            category.getProducts().add(product);
            categoryRepository.save(category);

            return productMapper.productToProductDTO(product);
        } else {
            throw new ResourceNotFoundException("Category " + productCreateDTO.getCategoryId() + " not found");
        }
    }

    @Override
    public ProductDTO updateProduct(ProductUpdateDTO productUpdateDTO) {
        Optional<Product> optionalProduct = productRepository.findById(productUpdateDTO.getId());
        if (!optionalProduct.isPresent()) {
            return null;
        }
        Product product = optionalProduct.get();
        if (productUpdateDTO.getCategoryId() != product.getCategory().getId()) {
            Category category = product.getCategory();
            categoryRepository.save(category.removeProduct(product));

            Optional<Category> optionalCategory = categoryRepository.findById(productUpdateDTO.getCategoryId());
            if (optionalCategory.isPresent()) {
                categoryRepository.save(optionalCategory.get().addProduct(product));
                product.setCategory(optionalCategory.get());
            }

        }
        if (productUpdateDTO.getName() != null) {
            product.setName(productUpdateDTO.getName());
        }
        if (productUpdateDTO.getDescription() != null) {
            product.setDescription(productUpdateDTO.getDescription());
        }
        if (productUpdateDTO.getAmount() != null) {
            product.setAmount(productUpdateDTO.getAmount());
        }
        if (productUpdateDTO.getPrice() != product.getPrice()) {
            product.setPrice(productUpdateDTO.getPrice());
        }

        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDTO(savedProduct);
    }

    @Override
    public ProductDTO getSingleProduct(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return productMapper.productToProductDTO(optionalProduct.get());
        } else {
            throw new ResourceNotFoundException("Product " + productId + " not found");
        }
    }

    @Override
    public void deleteProduct(int productID) {
        Optional<Product> optionalProduct = productRepository.findById(productID);
        if (optionalProduct.isPresent()) {
            Category category = optionalProduct.get().getCategory();
            categoryRepository.save(category.removeProduct(optionalProduct.get()));
            productRepository.delete(optionalProduct.get());
        } else {
            throw new ResourceNotFoundException("Product " + productID + " not found");
        }
    }

    @Override
    public Integer countProductsByCategoryId(Integer productId) {
        productRepository.count();
        return productId;
    }
}
