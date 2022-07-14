package com.example.doubleNineX.driven.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "PRODUCTS")
public class ProductEntity {

    @Id
    @Column(name = "NAME", length = 200, unique = true, nullable = false)
    private String name;

    @Column(name = "ITEM_PER_CARTON")
    private int itemPerCarton;

    @Column(name = "CARTON_PRICE")
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
