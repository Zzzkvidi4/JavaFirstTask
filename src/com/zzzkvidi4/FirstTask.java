package com.zzzkvidi4;


import com.zzzkvidi4.command.*;
import com.zzzkvidi4.validator.IntegerBetweenBoundariesValidator;

/*
"Написать программу (CLI, GUI) для работы со списком товаров магазина.

Каждый товар представлен уникальным идентификатором и ценой. Есть различные группы товаров, которые отличаются набором характеристик.

Список товаров хранится в памяти (нужно использовать стандартные коллекции Java, например, List), заполняется пользователем после старта программы.

Программа должна позволять:
- вывести список товаров на экран
- изменить конкретный товар
- удалить конкретный товар
- удалить несколько товаров
- добавить новый товар в список
- отфильтровать список товаров на основе заданного критерия (например, по цене; использовать методы коллекций)
- отсортировать список товаров на основе заданного критерия (например, по цене; использовать методы коллекций)

Все товары должны быть уникальны (переопределить equals для сравнения).

Необходимо разделить приложение на модули:
- иерархия классов для представления товаров:
  * базовый абстрактный класс с уникальным идентификатором и ценой
  * несколько классов наследников, которые расширяют базовый класс дополнительными полями и методами
- класс-обертка над списком продуктов с методами добавления, удаления, редактирования, фильтрации, сортировки и т.д.
- класс пользовательского интерфейса (CLI, GUI), переопределить toString() для печати информации о товаре"
 */
public class FirstTask {
    public static void main(String[] args){
        ProductList productList = new ProductList();
        CommandList commands = new CommandList();
        commands.addCommand(new AddProductCommand("Добавить продукт.", productList));
        commands.addCommand(new DeleteProductCommand<>("Удалить продукт по индексу.", productList));
        commands.addCommand(new RemoveByIDCommand("Удалить продукт по id.", productList));
        commands.addCommand(new PrintListCommand("Показать список продуктов.", productList));
        commands.addCommand(new SortProductCommand("Отсортировать список по цене.", productList));
        int cmdNumber = 0;
        do {
            commands.printCommandTitles("Выберите один из пунктов меню: ");
            try {
                cmdNumber = HelpUtils.getValueCLI(">",
                        new IntegerBetweenBoundariesValidator("Число должно быть между 0 и " + commands.actualSize() + "!",
                                false, 0, commands.actualSize()));
                if ((cmdNumber >= 1) && (cmdNumber <= commands.actualSize())) {
                    commands.executeCommand(cmdNumber - 1);
                }
            }
            catch(AbortOperationException ex){
                System.out.println(ex.getMessage());
            }
        } while (cmdNumber != 0);
    }
}
