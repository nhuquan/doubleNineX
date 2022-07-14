package com.example.doubleNineX.domain.calc;

import com.example.doubleNineX.domain.model.Product;

public interface PriceCalculator {

    double calcPrice(Product p, int quantity);
}
