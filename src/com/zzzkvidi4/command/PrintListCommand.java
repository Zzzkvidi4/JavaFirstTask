package com.zzzkvidi4.command;

import com.zzzkvidi4.HelpUtils;
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
        HelpUtils.printList(productList, System.out);
    }
}
