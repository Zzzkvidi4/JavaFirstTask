package com.zzzkvidi4.command;

import com.zzzkvidi4.HelpUtils;
import com.zzzkvidi4.ProductList;
import com.zzzkvidi4.comparator.PriceComparator;

public class SortProductCommand extends Command {
    private ProductList productList;

    public SortProductCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return productList.size() > 0;
    }

    @Override
    public void execute() {
        ProductList sortedList = new ProductList();
        sortedList.addAll(productList);
        sortedList.sort(new PriceComparator());
        HelpUtils.printList(sortedList, System.out);
    }
}
