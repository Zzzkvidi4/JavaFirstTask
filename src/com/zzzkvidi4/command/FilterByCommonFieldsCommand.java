package com.zzzkvidi4.command;

import com.zzzkvidi4.Product;
import com.zzzkvidi4.ProductList;

/**
 * Created by Роман on 21.09.2017.
 */
public class FilterByCommonFieldsCommand extends Command {
    private ProductList productList;

    public FilterByCommonFieldsCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return productList.size() != 0;
    }

    @Override
    public void execute() {

    }
}
