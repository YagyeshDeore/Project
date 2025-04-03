package com.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.entity.ProductEntity; // Correct entity import

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByName(String name); // Fixed entity reference
}
