package com.zzzkvidi4;

import java.util.Calendar;

public class Food extends Product {
    private int id;

    public Food(){
        super("", 1);
        this.id = count;
    }

    public Food(String title, double price){
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
