package com.zzzkvidi4;

import com.zzzkvidi4.command.CommandList;
import com.zzzkvidi4.validator.BasicValidator;
import com.zzzkvidi4.validator.IntegerBetweenBoundariesValidator;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;

public class HelpUtils {
    public static <T> T getValueCLI(String title, String abortString, BasicValidator<T> validator) throws AbortOperationException{
        String buf;
        boolean isInputCorrect = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T value = validator.initialValue();
        while (!isInputCorrect){
            System.out.print(title);
            try {
                buf = reader.readLine();
                if (buf.equals(abortString)){
                    throw new AbortOperationException("Отмена операции...");
                }
                value = validator.cast(buf);
                isInputCorrect = validator.validate(value);
                if (!isInputCorrect) {
                    System.out.println(validator.message());
                }
            }
            catch(IOException e){
                System.out.println("Внимание, произошла ошибка ввода!");
            }
            catch(NumberFormatException e){
                System.out.println("Внимание, вы ввели не число!");
            }
        }
        return value;
    }

    public static <T> T getValueCLIWithoutAbort(String title, BasicValidator<T> validator) {
        String buf;
        boolean isInputCorrect = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T value = validator.initialValue();
        while (!isInputCorrect){
            System.out.print(title);
            try {
                buf = reader.readLine();
                value = validator.cast(buf);
                isInputCorrect = validator.validate(value);
                if (!isInputCorrect) {
                    System.out.println(validator.message());
                }
            }
            catch(IOException e){
                System.out.println("Внимание, произошла ошибка ввода!");
            }
            catch(NumberFormatException e){
                System.out.println("Внимание, вы ввели не число!");
            }
        }
        return value;
    }

    public static void printList(ProductList list, PrintStream outputStream){
        Iterator<Product> iterator = list.iterator();
        while (iterator.hasNext()) {
            outputStream.println(iterator.next());
        }
    }

    public static void runCommandList(String commonTitle, CommandList cmdList) {
        int cmdNumber;
        int actualSize;
        do {
            cmdList.printCommandTitles(commonTitle);
            actualSize = cmdList.actualSize();
            cmdNumber = HelpUtils.getValueCLIWithoutAbort(
                    "--> ",
                    new IntegerBetweenBoundariesValidator("число должно быть между 1 и " + actualSize + "!", 1, actualSize));
            cmdList.executeCommand(cmdNumber - 1);
        } while (cmdNumber != actualSize);
    }
}
