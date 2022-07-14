package com.example.doubleNineX.domain.product;

import com.example.doubleNineX.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface GetProductHandler {
    List<Product> getAll();
    Optional<Product> findByName(String name);
}
