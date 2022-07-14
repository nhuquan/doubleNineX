package com.example.doubleNineX.domain.calc;

import com.example.doubleNineX.domain.model.Product;

public class PriceEngine implements PriceCalculator {

    public static final String QUANTITY_SHOULD_BE_POSITIVE_NUMBER = "quantity should be positive number";
    public static final double SINGLE_UNIT_PRICE_MULTIPLIER = 1.3;
    public static final double DISCOUNT_RATE = 0.9;
    public static final int DISCOUNT_QUANTITY = 3;

    @Override
    public double calcPrice(Product p, int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException(QUANTITY_SHOULD_BE_POSITIVE_NUMBER);

        double cartonPrice = calcCartonPrice(p, quantity);
        double singleUnitPrice = calcSingleUnitPrice(p, quantity);

        return (cartonPrice + singleUnitPrice) * getDiscountRate(p, quantity);
    }

    private double getDiscountRate(Product p, int quantity) {
        int cartonCount = quantity / p.itemPerCarton();
        if (cartonCount >= DISCOUNT_QUANTITY) return DISCOUNT_RATE;
        else return 1;
    }

    private double calcCartonPrice(Product p , int quantity) {
        int cartonCount = quantity / p.itemPerCarton();
        return p.cartonPrice() * cartonCount;
    }

    private double calcSingleUnitPrice(Product p, int quantity) {
        int unitCount = quantity % p.itemPerCarton();
        double normalSingleUnitPrice = p.cartonPrice() / p.itemPerCarton();
        return normalSingleUnitPrice * SINGLE_UNIT_PRICE_MULTIPLIER * unitCount;
    }

}
