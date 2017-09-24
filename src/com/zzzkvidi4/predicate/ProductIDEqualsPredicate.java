package com.zzzkvidi4.predicate;

import com.zzzkvidi4.Product;

import java.util.function.Predicate;

/**
 * Created by Роман on 21.09.2017.
 */
public class ProductIDEqualsPredicate implements Predicate<Product> {
    private int testId;

    public ProductIDEqualsPredicate(int testId){
        this.testId = testId;
    }

    @Override
    public boolean test(Product product) {
        return product.getId() == testId;
    }
}
