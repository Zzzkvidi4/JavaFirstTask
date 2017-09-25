package com.zzzkvidi4.command;

import com.zzzkvidi4.*;
import com.zzzkvidi4.validator.DoubleGreaterZeroValidator;
import com.zzzkvidi4.validator.IntegerBetweenBoundariesValidator;
import com.zzzkvidi4.validator.IntegerGreaterZeroValidator;
import com.zzzkvidi4.validator.StringNotEmptyValidator;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddProductCommand extends Command {
    private ProductList productList;

    public AddProductCommand(String title, ProductList productList){
        super(title);
        this.productList = productList;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void execute(){
        CommandList commands = new CommandList();
        commands.addCommand(new AddMedicineCommand("Добавить новое лекарство."));
        commands.addCommand(new AddFoodCommand("Добавить новый продукт питания."));
        int cmdNumber = 0;
        do {
            commands.printCommandTitles("Меню: ");
            try {
                cmdNumber = HelpUtils.getValueCLI("Выберите один из пунктов меню: ", new IntegerBetweenBoundariesValidator("Число должно быть между 0 и " + commands.actualSize() + "!", 0, commands.actualSize()));
                if ((cmdNumber >= 1) && (cmdNumber <= commands.actualSize())) {
                    commands.executeCommand(cmdNumber - 1);
                }
            }
            catch(AbortOperationException ex){
                System.out.println(ex.getMessage());
            }
        } while (cmdNumber != 0);
    }

    private class AddMedicineCommand extends Command {
        AddMedicineCommand(String title){
            super(title);
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {
            try {
                String name = HelpUtils.getValueCLI("Введите название лекарства: ", new StringNotEmptyValidator("Название лекарства не должно быть пустым!"));
                double price = HelpUtils.getValueCLI("Введите цену лекарства: ", new DoubleGreaterZeroValidator("Цена не должна быть меньше нуля!"));
                String category = HelpUtils.getValueCLI("Введите категорию лекарства: ", new StringNotEmptyValidator("Категория лекарства не должна быть пустой!"));
                Medicine med = new Medicine();
                med.setTitle(name);
                med.setPrice(new BigDecimal(price));
                med.setCategory(category);
                productList.add(med);
            }
            catch (AbortOperationException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private class AddFoodCommand extends Command {
        AddFoodCommand(String title){
            super(title);
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {
            try {
                String name = HelpUtils.getValueCLI("Введите название еды: ", new StringNotEmptyValidator("Название еды не должно быть пустым!"));
                double price = HelpUtils.getValueCLI("Введите цену: ", new DoubleGreaterZeroValidator("Цена должна быть больше нуля!"));
                int year = HelpUtils.getValueCLI("Введите год производства: ", new IntegerGreaterZeroValidator("Год должен быть больше нуля!", -1));
                int month = HelpUtils.getValueCLI("Введите месяц производста: ", new IntegerBetweenBoundariesValidator("Месяц должен быть между 1 и 12!", 1, 12));
                Calendar date = new GregorianCalendar(year, month - 1, 1);
                int maxDay = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
                int day = HelpUtils.getValueCLI("Введите день производства: ", new IntegerBetweenBoundariesValidator("День должен быть между 1 и " + maxDay + "!", 1, maxDay));
                date.set(GregorianCalendar.DAY_OF_MONTH, day);
                Food food = new Food();
                food.setTitle(name);
                food.setPrice(new BigDecimal(price));
                food.setDateOfManufacture(date);
                productList.add(food);
            }
            catch (AbortOperationException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
