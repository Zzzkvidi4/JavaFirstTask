package com.zzzkvidi4;

public class Medicine extends Product {
    private int id;

    Medicine(String title, double price){
        super(title, price);
        this.id = count;
    }

    @Override
    public String toString() {
        return getId() + " " + getTitle() + " " + getPrice();
    }

    @Override
    protected void initialize() {

    }

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getId() {
        return id;
    }
}
