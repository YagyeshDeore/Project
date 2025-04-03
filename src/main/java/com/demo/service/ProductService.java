package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.ProductEntity;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductEntity saveProduct(ProductEntity product) {
        return repository.save(product);
    }

    public List<ProductEntity> saveProducts(List<ProductEntity> products) {
        return repository.saveAll(products);
    }

    public List<ProductEntity> getProducts() {
        return repository.findAll();
    }

    public ProductEntity getProductById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    public ProductEntity getProductByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Product not found with Name: " + name));
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product removed: " + id;
    }

    public ProductEntity updateProduct(ProductEntity product) {
        return repository.save(product);
    }
}
