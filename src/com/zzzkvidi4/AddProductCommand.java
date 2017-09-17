package com.zzzkvidi4;

import com.zzzkvidi4.validator.DoubleGreaterZeroValidator;
import com.zzzkvidi4.validator.IntegerBetweenBoundariesValidator;
import com.zzzkvidi4.validator.IntegerGreaterZeroValidator;
import com.zzzkvidi4.validator.StringNotEmptyValidator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        CommandList commands = new CommandList();
        commands.addCommand(new AddMedicineCommand("Добавить новое лекарство."));
        commands.addCommand(new AddFoodCommand("Добавить новый продукт питания."));
    }

    class AddMedicineCommand extends Command {
        public AddMedicineCommand(String title){
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
                System.out.println(ex.getMessage());
            }
        }
    }

    class AddFoodCommand extends Command {
        public AddFoodCommand(String title){
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
            HelpUtils<Integer> intGetterCLI = new HelpUtils<>();
            try {
                String name = stringGetterCLI.getValueCLI("Введите название еды: ", new StringNotEmptyValidator("Название еды не должно быть пустым!"));
                double price = doubleGetterCLI.getValueCLI("Введите цену: ", new DoubleGreaterZeroValidator("Цена должна быть больше нуля!"));
                int year = intGetterCLI.getValueCLI("Введите год производства: ", new IntegerGreaterZeroValidator("Год должен быть больше нуля!", -1));
                int month = intGetterCLI.getValueCLI("Введите месяц производста: ", new IntegerBetweenBoundariesValidator("Месяц должен быть между 1 и 12!", 1, 12));
                Calendar date = new GregorianCalendar(year, month, 1);
                int maxDay = date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
                int day = intGetterCLI.getValueCLI("Введите день производства: ", new IntegerBetweenBoundariesValidator("День должен быть между 1 и " + maxDay + "!", 1, maxDay));
                date.set(GregorianCalendar.DAY_OF_MONTH, day);
                Food food = new Food();
                food.setTitle(name);
                food.setPrice(price);
                food.setDateOfManufacture(date);
                productList.add(food);
            }
            catch (AbortOperationException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
