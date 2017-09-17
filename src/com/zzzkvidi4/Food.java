package com.zzzkvidi4;

import java.util.Calendar;

public class Food extends Product {
    private int id;

    Food(){
        super("", 1);
        this.id = count;
    }

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

    private Calendar dateOfManufacture;


    private Calendar getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Calendar dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}
