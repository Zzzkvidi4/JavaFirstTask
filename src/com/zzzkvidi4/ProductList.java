package com.zzzkvidi4;

import java.util.*;
import java.util.function.Predicate;

public class ProductList {
    private ArrayList<Product> productList;

    ProductList(){
        productList = new ArrayList<>();
    }

    public boolean add(Product item){
        Iterator<Product> iter = productList.iterator();
        boolean isAdded = true;
        while (iter.hasNext()&&isAdded){
            isAdded = !(iter.next().equals(item));
        }
        if (isAdded) {
            productList.add(item);
        }
        return isAdded;
    }

    public void removeByID(int id) throws IllegalArgumentException{
        productList.removeIf(product -> product.getId() == id);
    }

    public ProductList filter(Predicate<Product> predicate){
        ProductList list = new ProductList();
        productList.stream().filter(predicate).forEach(list::add);
        return list;
    }

    public void sort(Comparator<Product> comparator){
        productList.sort(comparator);
    }

    public int size(){
        return productList.size();
    }

    public Iterator<Product> iterator(){
        return productList.iterator();
    }
}
