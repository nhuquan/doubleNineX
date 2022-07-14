package com.example.doubleNineX.driven.product;

import com.example.doubleNineX.domain.model.Product;
import com.example.doubleNineX.domain.model.ProductImpl;
import com.example.doubleNineX.domain.product.GetProductHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductGetterAdapter implements GetProductHandler {

    private final ProductRepository productRepository;

    public ProductGetterAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll().stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name).stream()
                .map(this::toProduct)
                .findAny();
    }

    private Product toProduct(ProductEntity e) {
        return new ProductImpl(e.getName(), e.getItemPerCarton(), e.getCartonPrice());
    }
}
