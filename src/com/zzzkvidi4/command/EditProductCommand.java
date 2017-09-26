package com.zzzkvidi4.command;

import com.zzzkvidi4.*;
import com.zzzkvidi4.validator.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        HelpUtils.printList(productList, System.out);
        System.out.println("Введите id элемента для изменения: ");
        try {
            int id = HelpUtils.getValueCLI(
                    "Введите id элемента для изменения: ",
                    "abort",
                    new IDExistsValidator("Элемент с данным id не существует!", -1, productList)
            );
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

    private class EditFoodCommand extends Command {
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
            CommandList cmdList = new CommandList();
            cmdList.addCommand(new EditProductId("Изменить id еды.", food));
            cmdList.addCommand(new EditProductTitle("Изменить название еды.", food));
            cmdList.addCommand(new EditProductPrice("Изменить цену еды.", food));
            cmdList.addCommand(new EditYearOfManufacture("Изменить год производства."));
            cmdList.addCommand(new EditMonthOfManufacture("Изменить месяц производства."));
            cmdList.addCommand(new EditDayOfManufacture("Изменить день производства."));
            cmdList.addCommand(new ExitCommand("Назад."));
            int cmdNumber;
            do{
                cmdNumber = HelpUtils.getValueCLIWithoutAbort("--> ", new IntegerBetweenBoundariesValidator("Число должно быть между 1 и 7!", 1, 7));
                cmdList.executeCommand(cmdNumber - 1);
            } while (cmdNumber != 7);
        }

        private class EditYearOfManufacture extends Command{

            EditYearOfManufacture(String title) {
                super(title);
            }

            @Override
            public void execute() {
                Calendar date = food.getDateOfManufacture();
                System.out.println("Текущий год производства - " + date.get(GregorianCalendar.YEAR));
                try {
                    int year = HelpUtils.getValueCLI(
                            "Введите новый год производства: ",
                            "abort",
                            new IntegerGreaterZeroValidator("Год должен быть болльше 0!", -1)
                    );
                    int day = date.get(GregorianCalendar.DAY_OF_MONTH);
                    date.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    date.set(GregorianCalendar.YEAR, year);
                    if (day <= date.getMaximum(GregorianCalendar.DAY_OF_MONTH)) {
                        date.set(GregorianCalendar.DAY_OF_MONTH, day);
                    }
                    food.setDateOfManufacture(date);
                }
                catch (AbortOperationException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        private class EditMonthOfManufacture extends Command{

            EditMonthOfManufacture(String title) {
                super(title);
            }

            @Override
            public void execute() {
                Calendar date = food.getDateOfManufacture();
                System.out.println("Текущий месяц производства - " + date.get(GregorianCalendar.MONTH));
                try {
                    int month = HelpUtils.getValueCLI(
                            "Введите новый месяц производства: ",
                            "abort",
                            new IntegerBetweenBoundariesValidator("Месяц должен быть между 1 и 12!", 1, 12)
                    );
                    int day = date.get(GregorianCalendar.DAY_OF_MONTH);
                    date.set(GregorianCalendar.DAY_OF_MONTH, 1);
                    date.set(GregorianCalendar.MONTH, month - 1);
                    if (day <= date.getMaximum(GregorianCalendar.DAY_OF_MONTH)) {
                        date.set(GregorianCalendar.DAY_OF_MONTH, day);
                    }
                    food.setDateOfManufacture(date);
                }
                catch (AbortOperationException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        private class EditDayOfManufacture extends Command{

            EditDayOfManufacture(String title) {
                super(title);
            }

            @Override
            public void execute() {
                Calendar date = food.getDateOfManufacture();
                System.out.println("Текущий день производства - " + date.get(GregorianCalendar.DAY_OF_MONTH));
                try {
                    int maxDayNumber = date.getMaximum(GregorianCalendar.DAY_OF_MONTH);
                    int day = HelpUtils.getValueCLI(
                            "Введите новый год производства: ",
                            "abort",
                            new IntegerBetweenBoundariesValidator("День должен быть между 1 и " + maxDayNumber + "!", 1, maxDayNumber)
                    );
                    date.set(GregorianCalendar.DAY_OF_MONTH, day);
                    food.setDateOfManufacture(date);
                }
                catch (AbortOperationException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private class EditProductId extends Command {
        Product product;

        EditProductId(String title, Product product) {
            super(title);
            this.product = product;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {
            System.out.println("Текущий id продукта - " + product.getId());
            try {
                int id = HelpUtils.getValueCLI(
                        "Введите новый id: ",
                        "abort",
                        new IDNotExistsValidator("Данный id уже существует!", -1, productList)
                );
                product.setId(id);
            }
            catch (AbortOperationException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private class EditProductTitle extends Command {
        Product product;

        EditProductTitle(String title, Product product) {
            super(title);
            this.product = product;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void execute() {
            System.out.println("Текущее название продукта - " + product.getTitle());
            try {
                String title = HelpUtils.getValueCLI(
                        "Введите новое название: ",
                        "abort",
                        new StringNotEmptyValidator("Название продукта не должно быть пустым!")
                );
                product.setTitle(title);
            }
            catch (AbortOperationException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private class EditProductPrice extends Command {
        Product product;

        EditProductPrice(String title, Product product) {
            super(title);
            this.product = product;
        }

        @Override
        public void execute() {
            System.out.println("Текущая цена продукта - " + product.getPrice());
            try {
                double price = HelpUtils.getValueCLI(
                        "Введите новую цену: ",
                        "abort",
                        new DoubleGreaterZeroValidator("Цена должна быть больше нуля!")
                );
                product.setPrice(new BigDecimal(price));
            }
            catch (AbortOperationException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private class  EditMedicineCommand extends Command {
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
            CommandList cmdList = new CommandList();
            cmdList.addCommand(new EditProductId("Изменить id лекарства.", medicine));
            cmdList.addCommand(new EditProductTitle("Изменить название лекарства.", medicine));
            cmdList.addCommand(new EditProductPrice("Изменить цену лекарства.", medicine));
            cmdList.addCommand(new EditCategory("Изменить категорию."));
            cmdList.addCommand(new ExitCommand("Назад."));
            int cmdNumber;
            do{
                cmdNumber = HelpUtils.getValueCLIWithoutAbort("--> ", new IntegerBetweenBoundariesValidator("Число должно быть между 1 и 5!", 1, 5));
                cmdList.executeCommand(cmdNumber - 1);
            } while (cmdNumber != 5);
        }

        private class EditCategory extends Command {

            EditCategory(String title) {
                super(title);
            }

            @Override
            public void execute() {
                System.out.println("Текущая категория - " + medicine.getCategory());
                try {
                    String category = HelpUtils.getValueCLI(
                            "Введите новую категорию лекарства: ",
                            "abort",
                            new StringNotEmptyValidator("Категория не может быть пустой!")
                    );
                    medicine.setCategory(category);
                }
                catch (AbortOperationException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
