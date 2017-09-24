package com.zzzkvidi4;

import java.math.BigDecimal;

/**
 * Created by Роман on 11.09.2017.
 */
public abstract class Product {

    Product(String title, BigDecimal price, int id){
        this.title = title;
        setPrice(price);
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.id = id;
    }

    Product(){
        this.title = "";
        setPrice(new BigDecimal(1));
    }

    private int id;

    private String title;

    public void setTitle(String title) {
        if (title.equals("")){
            throw new IllegalArgumentException("Название не должно быть пустой строкой!");
        }
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    private BigDecimal price;

    BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws IllegalArgumentException {
        if (price.compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("Цена не должна быть меньше либо равна нулю!");
        }
        this.price = price;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public abstract String toString();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
