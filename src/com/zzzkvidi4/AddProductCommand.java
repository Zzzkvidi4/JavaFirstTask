package com.zzzkvidi4;

import com.zzzkvidi4.validator.BasicValidator;
import com.zzzkvidi4.validator.DoubleGreaterZeroValidator;
import com.zzzkvidi4.validator.StringNotEmptyValidator;

import java.util.List;

public class AddProductCommand extends Command {
    private List<Product> productList;

    public AddProductCommand(String title, List<Product> productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void execute(){

    }

    class AddMedidcineCommand extends Command {
        public AddMedidcineCommand(String title){
            super(title);
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {
            HelpUtils<String> stringGetterCLI = new HelpUtils<>();
            HelpUtils<Double> doubleGetterCLI = new HelpUtils<>();
            try {
                String name = stringGetterCLI.getValueCLI("Введите название лекарства: ", new StringNotEmptyValidator("Название лекарства не должно быть пустым!"));
                double price = doubleGetterCLI.getValueCLI("Введите цену лекарства: ", new DoubleGreaterZeroValidator("Цена не должна быть меньше нуля!"));
                String category = stringGetterCLI.getValueCLI("Введите категорию лекарства: ", new StringNotEmptyValidator("Категория лекарства не должна быть пустой!"));
                Medicine med = new Medicine();
                med.setTitle(name);
                med.setPrice(price);
                med.setCategory(category);
                productList.add(med);
            }
            catch (AbortOperationException ex){

            }
        }
    }
}
