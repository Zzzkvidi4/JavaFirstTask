package com.zzzkvidi4;

/**
 * Created by Роман on 11.09.2017.
 */
public abstract class Product {
    public Product(String title, double price){
        this.title = title;
        setPrice(price);
    }

    private String title;

    public String getTitle() {
        return title;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не должна быть меньше либо равна нулю");
        }
        this.price = price;
    }
}
