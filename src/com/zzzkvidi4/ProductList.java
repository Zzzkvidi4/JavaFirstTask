package com.zzzkvidi4;

import java.awt.List;
import java.util.*;
import java.util.function.Predicate;

public class ProductList<T> {
    private ArrayList<T> productList;

    ProductList(){
        productList = new ArrayList<>();
    }

    public boolean add(T item){
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
        ProductList<T> list = new ProductList<>();
        productList.stream().filter(predicate).forEach(list::add);
        return list;
    }

    public void sort(Comparator<T> comparator){
        productList.sort(comparator);
    }

    public int size(){
        return productList.size();
    }

    Iterator<T> iterator(){
        return productList.iterator();
    }
}
