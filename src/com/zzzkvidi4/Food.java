package com.zzzkvidi4;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Food extends Product {

    public Food(){
        super();
        dateOfManufacture = new GregorianCalendar();
    }

    public Food(String title, BigDecimal price, int id){
        super(title, price, id);
        dateOfManufacture = new GregorianCalendar();
    }

    @Override
    public String toString() {
        return getId() + " " + getTitle() + " " + getDateOfManufacture().get(GregorianCalendar.DAY_OF_MONTH) + "." + (dateOfManufacture.get(GregorianCalendar.MONTH) + 1) + "." + dateOfManufacture.get(GregorianCalendar.YEAR);
    }

    private Calendar dateOfManufacture;


    public Calendar getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Calendar dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}
