package com.zzzkvidi4;

/**
 * Created by Роман on 11.09.2017.
 */
public abstract class Product {
    static int count = 0;

    Product(String title, double price){
        this.title = title;
        setPrice(price);
        initialize();
        count++;
    }

    private String title;

    String getTitle() {
        return title;
    }

    private double price;

    double getPrice() {
        return price;
    }

    private void setPrice(double price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не должна быть меньше либо равна нулю");
        }
        this.price = price;
    }

    @Override
    public abstract String toString();

    protected abstract void initialize();

    public abstract int getId();
}
