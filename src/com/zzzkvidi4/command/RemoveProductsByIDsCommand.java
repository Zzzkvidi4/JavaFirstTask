package com.zzzkvidi4.command;

import com.zzzkvidi4.AbortOperationException;
import com.zzzkvidi4.HelpUtils;
import com.zzzkvidi4.ProductList;
import com.zzzkvidi4.validator.StringNotEmptyValidator;

public class RemoveProductsByIDsCommand extends Command {
    private final ProductList productList;

    public RemoveProductsByIDsCommand(String title, ProductList productList) {
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return productList.size() > 1;
    }

    @Override
    public void execute() {
        try {
            String ids = HelpUtils.getValueCLI(
                    "Введите id, через пробелы: ",
                    "abort",
                    new StringNotEmptyValidator("Строка id не должна быть пустой!")
            );
            ids = ids.replaceAll("[^0-9]", " ");
            String[] splitedIds = ids.trim().split(" +");
            int count = 0;
            for(String id : splitedIds) {
                try{
                    int idValue = Integer.parseInt(id);
                    productList.removeByID(idValue);
                    count++;
                }
                catch (NumberFormatException e) {

                }
            }
            System.out.println("Распознано " + count + " идентификаторов из " + splitedIds.length + ".");
        }
        catch (AbortOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
