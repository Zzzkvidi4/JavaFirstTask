package com.zzzkvidi4.command;

import com.zzzkvidi4.AbortOperationException;
import com.zzzkvidi4.HelpUtils;
import com.zzzkvidi4.ProductList;
import com.zzzkvidi4.predicate.PriceGreaterOrEqualPredicate;
import com.zzzkvidi4.validator.DoubleGreaterZeroValidator;

import java.math.BigDecimal;

public class FilterByPriceCommand extends Command {

    private final ProductList productList;

    public FilterByPriceCommand(String title, ProductList productList) {
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled(){
        return productList.size() > 0;
    }

    @Override
    public void execute() {
        try {
            double price = HelpUtils.getValueCLI(
                    "Введите цену для фильтрации: ",
                    "abort",
                    new DoubleGreaterZeroValidator("Цена должна быть больше нуля!")
            );
            ProductList filteredList = productList.filter(new PriceGreaterOrEqualPredicate(new BigDecimal(price)));
            HelpUtils.printList(filteredList, System.out);
        }
        catch(AbortOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
