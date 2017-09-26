package com.zzzkvidi4.command;

import com.zzzkvidi4.AbortOperationException;
import com.zzzkvidi4.HelpUtils;
import com.zzzkvidi4.Product;
import com.zzzkvidi4.ProductList;
import com.zzzkvidi4.predicate.ProductIDEqualsPredicate;
import com.zzzkvidi4.validator.IntegerBetweenBoundariesValidator;
import com.zzzkvidi4.validator.IntegerGreaterZeroValidator;

/**
 * Created by Роман on 21.09.2017.
 */
public class RemoveByIDCommand extends Command {
    private ProductList productList;

    public RemoveByIDCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return (productList.size() > 0);
    }

    @Override
    public void execute() {
        try{
            int removeId = HelpUtils.getValueCLI(
                    "Введите id продукта для удаления: ",
                    "abort",
                    new IntegerGreaterZeroValidator("Id не может быть меньше нуля!", -1)
            );
            productList.removeByID(removeId);
        }
        catch(AbortOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
