package com.example.doubleNineX.domain.product;

import com.example.doubleNineX.domain.calc.PriceCalculator;
import com.example.doubleNineX.domain.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final GetProductHandler getProductHandler;
    private final PriceCalculator priceCalculator;

    public ProductServiceImpl(GetProductHandler getProductHandler, PriceCalculator priceCalculator) {
        this.getProductHandler = getProductHandler;
        this.priceCalculator = priceCalculator;
    }

    @Override
    public List<Product> findAll() {
        return getProductHandler.getAll();
    }

    @Override
    public double calcPrice(Product p, int quantity) {
        return priceCalculator.calcPrice(p, quantity);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return getProductHandler.findByName(name);
    }

}
