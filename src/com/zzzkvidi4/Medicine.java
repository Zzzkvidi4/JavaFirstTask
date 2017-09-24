package com.zzzkvidi4;

import java.math.BigDecimal;

public class Medicine extends Product {
    public Medicine(){
        super();
        this.category = "";
    }

    public Medicine(String title, BigDecimal price, int id){
        super(title, price, id);
    }

    @Override
    public String toString() {
        return getId() + " " + getTitle() + " " + getPrice();
    }

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
