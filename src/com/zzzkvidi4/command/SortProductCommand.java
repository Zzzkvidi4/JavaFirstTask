package com.zzzkvidi4.command;

import com.zzzkvidi4.ProductList;

public class SortProductCommand extends Command {
    private ProductList productList;

    SortProductCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return productList.size() > 0;
    }

    @Override
    public void execute() {

    }
}
