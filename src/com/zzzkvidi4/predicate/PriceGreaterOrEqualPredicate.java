package com.zzzkvidi4.predicate;

import com.zzzkvidi4.Product;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class PriceGreaterOrEqualPredicate implements Predicate<Product> {
    private final BigDecimal price;

    public PriceGreaterOrEqualPredicate(BigDecimal price){
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public boolean test(Product product) {
        return product.getPrice().compareTo(price) >= 0;
    }
}
