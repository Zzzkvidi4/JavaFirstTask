package com.zzzkvidi4;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductList {
    private ArrayList<Product> productList;

    ProductList(){
        productList = new ArrayList<>();
    }

    boolean add(Product product){
        Iterator<Product> iter = productList.iterator();
        boolean isAdded = true;
        while (iter.hasNext()&&isAdded){
            isAdded = !(iter.next().equals(product));
        }
        if (isAdded) {
            productList.add(product);
        }
        return isAdded;
    }

    public void remove(int index) throws IllegalArgumentException{
        if ((index < 0) || (index > productList.size())) {
            throw new IllegalArgumentException("Индекс не должен быть меньше нуля или больше размера коллекции!");
        }
        productList.remove(index);
    }

    Iterator<Product> iterator(){
        return productList.iterator();
    }
}
