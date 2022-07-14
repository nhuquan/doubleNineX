package com.example.doubleNineX.driving.product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("item_per_carton")
    private int itemPerCarton;

    @JsonProperty("carton_price")
    private double cartonPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemPerCarton() {
        return itemPerCarton;
    }

    public void setItemPerCarton(int itemPerCarton) {
        this.itemPerCarton = itemPerCarton;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }
}
