package com.example.doubleNineX.domain.model;

public class ProductImpl implements Product {

    private final String name;
    private final int itemPerCarton;
    private final double cartonPrice;

    public ProductImpl(String name, int itemPerCarton, double cartonPrice) {
        this.name = name;
        this.itemPerCarton = itemPerCarton;
        this.cartonPrice = cartonPrice;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public int itemPerCarton() {
        return this.itemPerCarton;
    }

    @Override
    public double cartonPrice() {
        return this.cartonPrice;
    }
}
