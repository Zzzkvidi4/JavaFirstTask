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
    private ProductList<Product> productList;

    public RemoveByIDCommand(String title, ProductList<Product> productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return (productList.size() > 0);
    }

    @Override
    public void execute() {
        HelpUtils<Integer> intGetter = new HelpUtils<>();
        try{
            int removeId = intGetter.getValueCLI("Введите id продукта для удаления",
                    new IntegerGreaterZeroValidator("Id не может быть меньше нуля!", -1));
            productList.removeBy(new ProductIDEqualsPredicate(removeId));
        }
        catch(AbortOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
