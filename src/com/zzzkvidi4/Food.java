package com.zzzkvidi4;

import java.util.Date;

public class Food extends Product {
    private int id;

    Food(String title, double price){
        super(title, price);
        this.id = count;
    }

    @Override
    public String toString() {
        return getId() + " " + getTitle() + " " + getDateOfManufacture();
    }

    @Override
    public int getId() {
        return id;
    }

    private Date dateOfManufacture;


    private Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}
