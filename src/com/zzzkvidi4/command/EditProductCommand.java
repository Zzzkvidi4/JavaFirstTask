package com.zzzkvidi4.command;

import com.zzzkvidi4.*;
import com.zzzkvidi4.validator.IDExistsValidator;

public class EditProductCommand extends Command {
    private ProductList productList;

    public EditProductCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return productList.size() > 0;
    }

    @Override
    public void execute() {
        System.out.println("Введите id элемента для изменения: ");
        HelpUtils<Integer> intGetter = new HelpUtils<>();
        try {
            int id = intGetter.getValueCLI("Введите id элемента для изменения:",
                    new IDExistsValidator("Элемент с данным id не существует!", -1, productList));
            Product product = productList.get(id);
            Command cmd;
            if (product instanceof Food){
                cmd = new EditFoodCommand("", (Food)product);
            } else {
                cmd = new EditMedicineCommand("", (Medicine)product);
            }
            cmd.execute();
        }
        catch (AbortOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    class EditFoodCommand extends Command {
        Food food;

        EditFoodCommand(String title, Food food) {
            super(title);
            this.food = food;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {

        }
    }

    class  EditMedicineCommand extends Command {
        Medicine medicine;

        EditMedicineCommand(String title, Medicine medicine){
            super(title);
            this.medicine = medicine;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {

        }
    }
}
