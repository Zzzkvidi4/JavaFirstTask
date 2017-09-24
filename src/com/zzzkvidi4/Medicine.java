package com.zzzkvidi4;

public class Medicine extends Product {
    private int id;

    public Medicine(){
        super();
        this.id = count;
        this.category = "";
    }

    public Medicine(String title, double price){
        super(title, price);
        this.id = count;
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


    public int getId() {
        return id;
    }
}
