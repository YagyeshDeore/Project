package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.ProductEntity;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return service.saveProduct(product);
    }

    @PostMapping("/add-multiple")
    public List<ProductEntity> addProducts(@RequestBody List<ProductEntity> products) {
        return service.saveProducts(products);
    }

    @GetMapping
    public List<ProductEntity> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public ProductEntity findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/by-name")
    public ProductEntity findProductByName(@RequestParam String name) {
        return service.getProductByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PutMapping("/update")
    public ProductEntity updateProduct(@RequestBody ProductEntity product) {
        return service.updateProduct(product);
    }
}
