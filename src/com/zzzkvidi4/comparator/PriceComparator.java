package com.zzzkvidi4.comparator;

import com.zzzkvidi4.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice().subtract(o2.getPrice()).intValue();
    }
}
