package com.zzzkvidi4.command;

import com.zzzkvidi4.AbortOperationException;
import com.zzzkvidi4.HelpUtils;
import com.zzzkvidi4.ProductList;
import com.zzzkvidi4.validator.IntegerBetweenBoundariesValidator;

/**
 * Created by Роман on 18.09.2017.
 */
public class DeleteProductCommand<T> extends Command {
    private ProductList list;

    public DeleteProductCommand(String title, ProductList list) {
        super(title);
        this.list = list;
    }

    @Override
    public boolean isEnabled() {
        return list.size() > 0;
    }

    @Override
    public void execute() {
        /*try {
            //int index = HelpUtils.getValueCLI("Введите номер продукта (от " + 1 + " до " + list.size() + ":", new IntegerBetweenBoundariesValidator("Число должно быть между 1 и " + list.size() + "!", 1, list.size()));
            //list.remove(index - 1);
        }
        catch (AbortOperationException ex){
            System.out.println(ex.getMessage());
        }*/
    }
}
