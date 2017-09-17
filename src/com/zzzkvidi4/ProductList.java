package com.zzzkvidi4;

import java.awt.List;
import java.util.*;
import java.util.function.Predicate;

public class ProductList<T> {
    private ArrayList<T> productList;

    ProductList(){
        productList = new ArrayList<>();
    }

    boolean add(T item){
        Iterator<T> iter = productList.iterator();
        boolean isAdded = true;
        while (iter.hasNext()&&isAdded){
            isAdded = !(iter.next().equals(item));
        }
        if (isAdded) {
            productList.add(item);
        }
        return isAdded;
    }

    public void remove(int index) throws IllegalArgumentException{
        if ((index < 0) || (index > productList.size())) {
            throw new IllegalArgumentException("Индекс не должен быть меньше нуля или больше размера коллекции!");
        }
        productList.remove(index);
    }

    public ProductList filter(Predicate<T> predicate){
        ProductList list = new ProductList();
        for (T item: productList) {
            if (predicate.test(item)){
                list.add(item);
            }
        }
        return list;
    }

    public void sort(Comparator<T> comparator){
        productList.sort(comparator);
    }

    Iterator<T> iterator(){
        return productList.iterator();
    }
}
