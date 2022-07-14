package com.example.doubleNineX.domain.product;

import com.example.doubleNineX.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    double calcPrice(Product p, int quantity);
    Optional<Product> findByName(String name);
}
