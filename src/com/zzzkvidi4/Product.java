package com.zzzkvidi4;

/**
 * Created by Роман on 11.09.2017.
 */
public abstract class Product {
    static int count = 0;

    Product(String title, double price){
        this.title = title;
        setPrice(price);
        count++;
    }

    Product(){
        this.title = "";
        setPrice(1);
        count++;
    }

    private String title;

    void setTitle(String title) {
        this.title = title;
    }

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

    public abstract int getId();
}
