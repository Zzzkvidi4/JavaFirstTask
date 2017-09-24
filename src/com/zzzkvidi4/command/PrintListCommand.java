package com.zzzkvidi4.command;

import com.zzzkvidi4.Product;
import com.zzzkvidi4.ProductList;

import java.util.Iterator;

public class PrintListCommand extends Command {
    private ProductList productList;

    public PrintListCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return productList.size() > 0;
    }

    @Override
    public void execute() {
        Iterator<Product> iterator = productList.iterator();
        Product product;
        while (iterator.hasNext()) {
            product = iterator.next();
            System.out.println(product.toString());
        }
    }
}
